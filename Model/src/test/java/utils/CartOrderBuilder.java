package utils;

import enums.OrderItemType;
import lombok.Builder;
import model.Cart;
import model.Order;
import model.OrderItemContainer;
import model.Seller;

public class CartOrderBuilder implements EntityBuilderService<OrderItemContainer> {

    /**
     * Uses a {@link Builder} to build a {@link Cart} or an {@link Order}
     *
     * @param params OrderItemType, Id, isShared, Seller
     * @return a {@link OrderItemContainer}
     */
    @Override
    public OrderItemContainer getEntityWithBuilder(Object... params) {
        OrderItemType type = (OrderItemType) params[0];
        long id = (long) params[1];
        boolean isShared = (boolean) params[2];
        OrderItemContainer container;
        if (OrderItemType.CART.equals(type)) {
            container = Cart.builder()
                    .id(id)
                    .isSharedCart(isShared)
                    .build();
        } else {
            Seller seller = (Seller) params[3];
            container = Order.builder()
                    .id(id)
                    .isSharedOrder(isShared)
                    .seller(seller)
                    .build();
        }
        return container;
    }

    /**
     * Uses a constructor to build a {@link Cart} or an {@link Order}
     *
     * @param params OrderItemType, Id, isShared, Seller
     * @return a {@link OrderItemContainer}
     */
    @Override
    public OrderItemContainer getEntityWithConstructor(Object... params) {
        OrderItemType type = (OrderItemType) params[0];
        long id = (long) params[1];
        boolean isShared = (boolean) params[2];
        OrderItemContainer container;
        if (OrderItemType.CART.equals(type)) {
            container = new Cart(isShared);
            container.setId(id);
        } else {
            Seller seller = (Seller) params[3];
            container = new Order(isShared, seller);
            container.setId(id);
        }
        return container;
    }

}
