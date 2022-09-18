package utils;

import enums.ItemContainerType;
import lombok.Builder;
import model.Cart;
import model.ItemContainer;
import model.Order;
import model.OrderItem;
import model.Seller;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class CartOrderBuilder implements EntityBuilderService<ItemContainer> {

    /**
     * Uses a {@link Builder} to build a {@link Cart} or an {@link Order}
     *
     * @param params ItemContainerType, Id, isShared, Seller
     * @return a {@link ItemContainer}
     */
    @Override
    public ItemContainer getEntityWithBuilder(Object... params) {
        ItemContainerType type = (ItemContainerType) params[0];
        long id = (long) params[1];
        boolean isShared = (boolean) params[2];
        ItemContainer container;
        if (ItemContainerType.CART.equals(type)) {
            container = Cart.builder()
                    .isSharedCart(isShared)
                    .build();
            container.setId(id);
        } else {
            CopyOnWriteArrayList<OrderItem> items = params[3] == null ? new CopyOnWriteArrayList<>() : new CopyOnWriteArrayList<OrderItem>((Collection<OrderItem>) params[3]);
            Seller seller = (Seller) params[4];
            container = Order.builder()
                    .orderItems(items)
                    .isSharedOrder(isShared)
                    .build();
            container.setId(id);
            ((Order) container).setSeller(seller);
        }
        return container;
    }

    /**
     * Uses a constructor to build a {@link Cart} or an {@link Order}
     *
     * @param params ItemContainerType, Id, isShared, Seller
     * @return a {@link ItemContainer}
     */
    @Override
    public ItemContainer getEntityWithConstructor(Object... params) {
        ItemContainerType type = (ItemContainerType) params[0];
        long id = (long) params[1];
        boolean isShared = (boolean) params[2];
        ItemContainer container;
        if (ItemContainerType.CART.equals(type)) {
            container = new Cart(isShared);
            container.setId(id);
        } else {
            CopyOnWriteArrayList<OrderItem> items = params[3] == null ? new CopyOnWriteArrayList<>() : new CopyOnWriteArrayList<OrderItem>((Collection<OrderItem>) params[3]);
            Seller seller = (Seller) params[4];
            container = new Order(items, isShared);
            container.setId(id);
            ((Order) container).setSeller(seller);
        }
        return container;
    }

}
