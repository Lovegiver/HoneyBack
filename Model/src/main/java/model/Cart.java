package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Entity
@Table(name = "CART")
@ToString(onlyExplicitlyIncluded = true)
public class Cart extends OrderItemContainer {

    @Column(name = "crt_is_shared")
    @Getter @Setter @ToString.Include
    private boolean isSharedCart;
    /* RELATIONSHIP */
    /** The Buyer, owner of this Cart */
    @ManyToMany @JoinTable(name = "USER_CART",
        joinColumns = { @JoinColumn(name = "crt_id") },
            inverseJoinColumns = { @JoinColumn(name = "usr_id") }
    )
    @Getter @Setter
    private Set<Buyer> buyers;
    /** The OrderItems contained in this Cart */
    @OneToMany(mappedBy = "cart")
    @Getter @Setter
    private List<OrderItem> orderItems;

    @Builder
    protected Cart() {}

    /**
     * @return an amount
     */
    @Override
    public BigDecimal getTotalAmountNoVAT() {
        var amount = new AtomicReference<BigDecimal>(BigDecimal.ZERO);
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
        var amount = new AtomicReference<BigDecimal>(BigDecimal.ZERO);
        this.orderItems.forEach(line -> {
            amount.set(amount.get().add(line.getTotalAmountWithVAT()));
        });
        this.totalAmountNoVAT = amount.get();
        return amount.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return buyers.equals(cart.buyers) && orderItems.equals(cart.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyers, orderItems);
    }
}
