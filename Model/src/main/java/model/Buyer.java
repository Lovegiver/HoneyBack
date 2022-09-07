package model;

import enums.GenderType;
import enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BUYER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Buyer extends User {

    /* RELATIONSHIP */
    @OneToOne(mappedBy = "buyer")
    private Cart cart;
    /** User's orders : sent orders for Buyers or received ones for Sellers */
    @ManyToMany(mappedBy = "buyers")
    private final Set<Order> orders = new LinkedHashSet<>();

    @Builder
    public Buyer(@NonNull String email, @NonNull String password, @NonNull String pseudo,
                 @NonNull String firstname, @NonNull String lastname, @NonNull GenderType genderType) {
        super(UserType.BUYER, email, password, pseudo, firstname, lastname, genderType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buyer)) return false;
        if (!super.equals(o)) return false;
        Buyer buyer = (Buyer) o;
        return cart.equals(buyer.cart) && orders.equals(buyer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cart, orders);
    }
}
