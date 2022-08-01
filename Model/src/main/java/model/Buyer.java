package model;

import enums.GenderType;
import enums.UserType;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Buyer extends User {

    @Getter @Setter @ToString.Include
    private GenderType genderType;

    @Builder
    public Buyer(@NonNull String email, @NonNull String password, @NonNull String pseudo,
                 @NonNull String firstname, @NonNull String lastname, @NonNull GenderType genderType) {
        super(UserType.BUYER, email, password, pseudo, firstname, lastname);
        this.genderType = genderType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buyer)) return false;
        if (!super.equals(o)) return false;
        Buyer buyer = (Buyer) o;
        return genderType == buyer.genderType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), genderType);
    }
}
