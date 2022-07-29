package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@ToString(onlyExplicitlyIncluded = true)
public class Address {

    @Getter @Setter @ToString.Include
    private long id;
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
