import enums.OrderItemType;
import enums.UserType;
import model.Buyer;
import model.Cart;
import model.OrderItemContainer;
import model.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CartOrderBuilder;
import utils.EntityBuilderService;
import utils.UserBuilder;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private final static Logger LOG = LoggerFactory.getLogger("Product Testing");
    private final EntityBuilderService<? extends User> userBuilder = new UserBuilder();
    private final EntityBuilderService<? extends OrderItemContainer> containerBuilder = new CartOrderBuilder();

    @Test
    public void createBuyerWithCartTest() {

        long buyerId1 = 1L;
        long buyerId2 = 2L;
        long cartId1 = 1L;
        long cartId2 = 2L;

        Buyer buyer1 = (Buyer) userBuilder.getEntityWithBuilder(UserType.BUYER, buyerId1);
        Buyer buyer2 = (Buyer) userBuilder.getEntityWithConstructor(UserType.BUYER, buyerId2);
        Cart cart1 = (Cart) containerBuilder.getEntityWithBuilder(OrderItemType.CART, cartId1, true);
        Cart cart2 = (Cart) containerBuilder.getEntityWithConstructor(OrderItemType.CART, cartId2, true);

        assertNotNull(buyer1);
        assertNotNull(buyer2);
        assertNotNull(cart1);
        assertNotNull(cart2);

        cart1.addBuyer(buyer1);
        cart2.addBuyer(buyer2);

        assertNotEquals(buyer1, buyer2);
        assertNotEquals(cart1, cart2);
        assertNotEquals(buyer1.hashCode(), buyer2.hashCode());
        assertNotEquals(cart1.hashCode(), cart2.hashCode());

        LOG.debug(buyer1.toString());
        LOG.debug(buyer2.toString());
        LOG.debug(cart1.toString());
        LOG.debug(cart2.toString());

    }
}
