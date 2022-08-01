package model;

import enums.AddressType;
import lombok.*;

import java.util.Objects;

@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Address {

    @Getter @Setter @ToString.Include
    private long id;
    @Getter @Setter @ToString.Include
    private AddressType addressType;
    @Getter @Setter @ToString.Include
    private User userId;
    @Getter @Setter @ToString.Include
    private String street1;
    @Getter @Setter @ToString.Include
    private String street2;
    @Getter @Setter @ToString.Include
    private String zipcode;
    @Getter @Setter @ToString.Include
    private String city;
    @Getter @Setter @ToString.Include
    private String country;
    @Getter @Setter @ToString.Include
    private String state;

    public Address(@NonNull AddressType type, @NonNull User user, @NonNull String street1, @NonNull String street2,
                   @NonNull String zipcode, @NonNull String city, @NonNull String country, String state) {
        this.addressType = type;
        this.userId = user;
        this.street1 = street1;
        this.street2 = street2;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return id == address.id && userId.equals(address.userId) && street1.equals(address.street1)
                && Objects.equals(street2, address.street2) && zipcode.equals(address.zipcode)
                && city.equals(address.city) && country.equals(address.country) && Objects.equals(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, street1, street2, zipcode, city, country, state);
    }
}
