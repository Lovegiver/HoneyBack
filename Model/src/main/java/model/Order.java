package model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Entity
@Table(name = "ORDER")
@ToString(onlyExplicitlyIncluded = true)
public class Order extends OrderItemContainer {

    @Column(name = "ord_is_shared")
    @Getter @Setter @ToString.Include
    private boolean isSharedOrder;
    /* RELATIONSHIP */
    /** The OrderItem contained in this Order */
    @OneToMany(mappedBy = "order")
    @Getter @Setter
    private List<OrderItem> orderItems;
    /** The Buyers involved in this Order or just one */
    @ManyToMany @JoinTable(name = "USER_ORDER",
        joinColumns = { @JoinColumn(name = "ord_id") },
            inverseJoinColumns = { @JoinColumn(name = "usr_id") }
    )
    @Getter @Setter @ToString.Include
    private Set<User> buyers = new LinkedHashSet<>();
    /** The Seller for the Products in this Order */
    @ManyToOne @JoinColumn(name = "ord_usr_id_seller")
    @Getter @Setter
    private Seller seller;

    @Builder
    public Order() {}

    /**
     * @return an amount
     */
    @Override
    public BigDecimal getTotalAmountNoVAT() {
        var amount = new AtomicReference<>(BigDecimal.ZERO);
        this.orderItems.forEach(line -> {
            amount.set(amount.get().add(line.getTotalAmountNoVAT()));
        });
        this.totalAmountNoVAT = amount.get();
        return amount.get();
    }

    /**
     * @return an amount
     */
    @Override
    public BigDecimal getTotalAmountWithVAT() {
        var amount = new AtomicReference<>(BigDecimal.ZERO);
        this.orderItems.forEach(line -> {
            amount.set(amount.get().add(line.getTotalAmountWithVAT()));
        });
        this.totalAmountNoVAT = amount.get();
        return amount.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return isSharedOrder == order.isSharedOrder && orderItems.equals(order.orderItems) && buyers.equals(order.buyers)
                && seller.equals(order.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSharedOrder, orderItems, buyers, seller);
    }
}
