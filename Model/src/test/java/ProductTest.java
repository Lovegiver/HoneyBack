import enums.GenderType;
import enums.UserType;
import enums.WeightUnitType;
import model.Product;
import model.Seller;
import model.Unit;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private final static Logger LOG = LoggerFactory.getLogger("Product Testing");

    @Test
    public void createProductTest() {

        long sellerId = 1L;
        long productId = 1L;
        Unit unit = WeightUnitType.GR;
        Seller seller = (Seller) EntityBuilder.getUser(UserType.SELLER, sellerId);
        Product product = EntityBuilder.getProduct(unit, productId);
        seller.addProduct(product);

        assertNotNull(seller);
        assertEquals(EntityBuilder.company, seller.getCompanyName());
        assertEquals(EntityBuilder.rcs, seller.getRcs());
        assertEquals(EntityBuilder.siren, seller.getSiren());
        assertEquals(sellerId, seller.getId());
        assertEquals(UserType.SELLER, seller.getUserType());
        assertEquals(EntityBuilder.pseudo, seller.getPseudo());
        assertEquals(EntityBuilder.firstname, seller.getFirstname());
        assertEquals(EntityBuilder.lastname, seller.getLastname());
        assertEquals(EntityBuilder.userDescription, seller.getDescription());
        assertEquals(EntityBuilder.email, seller.getEmail());
        assertEquals(EntityBuilder.password, seller.getPassword());
        assertEquals(GenderType.WOMAN, seller.getGenderType());
        assertEquals(EntityBuilder.lastConnected, seller.getLastConnection());
        assertEquals(seller, product.getSeller());

        assertNotNull(product);
        assertEquals(productId, product.getId());
        assertEquals(EntityBuilder.name, product.getName());
        assertEquals(EntityBuilder.reference, product.getReference());
        assertEquals(EntityBuilder.productDescription, product.getDescription());
        assertEquals(unit, product.getUnit());
        assertEquals(EntityBuilder.quantity, product.getQuantity());
        assertEquals(seller, product.getSeller());
        assertEquals(1, seller.getProducts().size());
        assertTrue(seller.getProducts().contains(product));
        seller.getProducts().forEach(p -> {
            assertEquals(product, p);
        });

        seller.removeProduct(product);
        assertEquals(0, seller.getProducts().size());
        assertNull(product.getSeller());

        LOG.debug(product.toString());

    }

}
