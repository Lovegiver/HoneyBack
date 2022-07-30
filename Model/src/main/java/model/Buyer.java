package model;

import enums.GenderType;
import enums.UserType;
import lombok.*;

public class Buyer extends User {

    @Getter @Setter @ToString.Include
    private GenderType genderType;

    @Builder
    public Buyer(@NonNull UserType type, @NonNull String email, @NonNull String password, @NonNull String pseudo,
                 @NonNull String firstname, @NonNull String lastname, @NonNull GenderType genderType) {
        super(type, email, password, pseudo, firstname, lastname);
        this.genderType = genderType;
    }


}
