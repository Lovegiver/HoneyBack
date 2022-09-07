package model;

import enums.GenderType;
import enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USER")
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class User implements PictureHolder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    @Getter @Setter @ToString.Include
    private long id;
    @Column(name = "usr_type") @Enumerated(EnumType.STRING)
    @Getter @Setter @ToString.Include
    private UserType userType;
    @Column(name = "usr_pseudo")
    @Getter @Setter @ToString.Include
    private String pseudo;
    @Column(name = "usr_firstname")
    @Getter @Setter @ToString.Include
    private String firstname;
    @Column(name = "usr_lastname")
    @Getter @Setter @ToString.Include
    private String lastname;
    @Column(name = "usr_description")
    @Getter @Setter
    private String description;
    @Column(name = "usr_email")
    @Getter @Setter @ToString.Include
    private String email;
    @Column(name = "usr_pwd")
    @Getter @Setter @ToString.Include
    private String password;
    @Column(name = "usr_last_co") @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastConnection;
    @Column(name = "usr_gender") @Enumerated(EnumType.STRING)
    @Getter @Setter @ToString.Include
    private GenderType genderType;

    /* RELATIONSHIP */
    /** User's addresses */
    @OneToMany(mappedBy = "user")
    @Getter @Setter
    private Set<Address> addresses = new LinkedHashSet<>();
    /** User's profile picture */
    @OneToOne(mappedBy = "user")
    @Getter @Setter
    private Picture associatedPicture;

    protected User(@NonNull UserType type, @NonNull String email, @NonNull String password, @NonNull String pseudo,
                   @NonNull String firstname, @NonNull String lastname, @NonNull GenderType genderType) {
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
    public void associatePicture(Picture picture) {
        this.associatedPicture = picture;
    }

    @Override
    public void dissociatePicture(Picture picture) {
        this.associatedPicture = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(pseudo, user.pseudo) && firstname.equals(user.firstname) && lastname.equals(user.lastname) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pseudo, firstname, lastname, email);
    }
}
