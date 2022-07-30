package model;

import enums.UserType;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@ToString(onlyExplicitlyIncluded = true)
class User {

    @Getter @Setter @ToString.Include
    private long id;
    @Getter @Setter @ToString.Include
    private UserType userType;
    @Getter @Setter @ToString.Include
    private String email;
    @Getter @Setter @ToString.Include
    private String password;
    @Getter @Setter @ToString.Include
    private String pseudo;
    @Getter @Setter @ToString.Include
    private String firstname;
    @Getter @Setter @ToString.Include
    private String lastname;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private Set<Address> addresses = new LinkedHashSet<>();

    protected User() {}

    protected User(@NonNull UserType type, @NonNull String email, @NonNull String password, @NonNull String pseudo,
                   @NonNull String firstname, @NonNull String lastname) {
        this.userType = type;
        this.email = email;
        this.password = password;
        this.pseudo = pseudo;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /** Adds an {@link Address} to the {@link User}'s collection */
    public void addAddress(@NonNull Address address) { this.addresses.add(address); }

    /** Removes an {@link Address} from the {@link User}'s collection */
    public void removeAddress(@NonNull Address address) { this.addresses.remove(address); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && email.equals(user.email) && password.equals(user.password) && pseudo.equals(user.pseudo)
                && firstname.equals(user.firstname) && lastname.equals(user.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, pseudo, firstname, lastname);
    }

}
