package model;

import enums.GenderType;
import enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "SELLER")
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller extends User {

    @Column(name = "usr_company_name")
    @Getter @Setter @ToString.Include
    private String companyName;
    @Column(name = "usr_rcs")
    @Getter @Setter @ToString.Include
    private String rcs;
    @Column(name = "usr_siren")
    @Getter @Setter @ToString.Include
    private String siren;
    /* RELATIONSHIP */
    @OneToMany(mappedBy = "seller")
    @Getter @Setter
    private Set<Product> products;
    @OneToMany(mappedBy = "seller")
    @Getter @Setter @ToString.Include
    private Set<Order> orders;

    @Builder
    public Seller(@NonNull String email, @NonNull String password, @NonNull String pseudo,
                  @NonNull String firstname, @NonNull String lastname, @NonNull GenderType genderType,
                  @NonNull String companyName, String rcs) {
        super(UserType.SELLER, email, password, pseudo, firstname, lastname, genderType);
        this.companyName = companyName;
        this.rcs = rcs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seller)) return false;
        if (!super.equals(o)) return false;
        Seller seller = (Seller) o;
        return companyName.equals(seller.companyName) && Objects.equals(rcs, seller.rcs) && Objects.equals(siren, seller.siren)
                && products.equals(seller.products) && orders.equals(seller.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), companyName, rcs, siren, products, orders);
    }
}
