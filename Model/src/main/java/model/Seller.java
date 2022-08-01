package model;

import enums.UserType;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller extends User {

    @Getter @Setter @ToString.Include
    private String companyName;
    @Getter @Setter @ToString.Include
    private String rcs;

    @Builder
    public Seller(@NonNull String email, @NonNull String password, @NonNull String pseudo,
                  @NonNull String firstname, @NonNull String lastname, @NonNull String companyName, String rcs) {
        super(UserType.SELLER, email, password, pseudo, firstname, lastname);
        this.companyName = companyName;
        this.rcs = rcs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seller)) return false;
        if (!super.equals(o)) return false;
        Seller seller = (Seller) o;
        return companyName.equals(seller.companyName) && rcs.equals(seller.rcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), companyName, rcs);
    }
}
