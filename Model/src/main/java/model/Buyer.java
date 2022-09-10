package model;

import enums.GenderType;
import enums.UserType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BUYER")
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Buyer extends User {

    /* RELATIONSHIP */
    @ManyToMany(mappedBy = "buyers")
    @Getter @Setter @Builder.Default
    private Set<Cart> carts = new LinkedHashSet<>();
    /** User's orders : sent orders for Buyers or received ones for Sellers */
    @ManyToMany(mappedBy = "buyers")
    @Getter @Setter @Builder.Default
    private Set<Order> orders = new LinkedHashSet<>();

    public Buyer(@NonNull String email, @NonNull String password, @NonNull String pseudo,
                 @NonNull String firstname, @NonNull String lastname, @NonNull GenderType genderType, LocalDateTime lastConnected) {
        super(UserType.BUYER, email, password, pseudo, firstname, lastname, genderType, lastConnected);
        this.carts = new LinkedHashSet<>();
        this.orders = new LinkedHashSet<>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void removeOrder(Order order) {
        this.orders.remove(order);
    }

    public void addCart(Cart cart) {
        this.carts.add(cart);
    }

    public void removeCart(Cart cart) {
        this.carts.remove(cart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Buyer buyer = (Buyer) o;
        return carts.equals(buyer.carts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carts);
    }
}
