package model;

import enums.UserType;
import lombok.*;

public class Seller extends User {

    @Getter @Setter @ToString.Include
    private String companyName;
    @Getter @Setter @ToString.Include
    private String rcs;

    @Builder
    public Seller(@NonNull UserType type, @NonNull String email, @NonNull String password, @NonNull String pseudo,
                  @NonNull String firstname, @NonNull String lastname, @NonNull String companyName, String rcs) {
        super(type, email, password, pseudo, firstname, lastname);
        this.companyName = companyName;
        this.rcs = rcs;
    }


}
