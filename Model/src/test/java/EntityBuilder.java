import enums.GenderType;
import enums.UserType;
import model.*;

import java.time.LocalDateTime;
import java.time.Month;

public class EntityBuilder {

    /* USER */
    public static String email = "user@honey.com";
    public static String password = "password";
    public static String pseudo = "pseudo";
    public static String firstname = "firstname";
    public static String lastname = "lastname";
    public static String company = "company";
    public static String rcs = "rcs";
    public static String siren = "siren";
    public static GenderType man = GenderType.MAN;
    public static GenderType woman = GenderType.WOMAN;
    public static LocalDateTime lastConnected = LocalDateTime.of(1971, Month.JULY.getValue(), 8, 14, 0);
    public static String userDescription = "Producteur de miel";

    /* PRODUCT */
    public static String name = "Miel de lavande";
    public static String reference = "M01LAV";
    public static String productDescription = "Un miel de toute beauté";
    public static int quantity = 500;

    /**
     * Generates a {@link User} object that can be a {@link Buyer} or a {@link Seller}
     * @param type the {@link GenderType} to use
     * @param id the {@link User#getId()}
     * @return a {@link User}
     */
    public static User getUser(UserType type, long id) {
        User user;
        if (UserType.BUYER.equals(type)) {
            user = Buyer.builder()
                    .id(id)
                    .userType(type)
                    .email(email)
                    .password(password)
                    .pseudo(pseudo)
                    .firstname(firstname)
                    .lastname(lastname)
                    .genderType(GenderType.MAN)
                    .lastConnection(lastConnected)
                    .description(userDescription)
                    .build();
        } else {
            user = Seller.builder()
                    .id(id)
                    .userType(type)
                    .email(email)
                    .password(password)
                    .pseudo(pseudo)
                    .firstname(firstname)
                    .lastname(lastname)
                    .genderType(GenderType.WOMAN)
                    .lastConnection(lastConnected)
                    .description(userDescription)
                    .companyName(company)
                    .rcs(rcs)
                    .siren(siren)
                    .build();
        }
        return user;
    }


    public static Product getProduct(Unit unit, long id) {
        return Product.builder()
            .id(id)
            .name(name)
            .reference(reference)
            .description(productDescription)
            .unit(unit)
            .quantity(quantity)
            .build();
    }

}
