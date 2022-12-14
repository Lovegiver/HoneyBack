package com.citizenweb.tooling.honeyback.model.utils;

import lombok.NoArgsConstructor;
import com.citizenweb.tooling.honeyback.core.domain.model.Product;
import com.citizenweb.tooling.honeyback.core.domain.model.Seller;
import com.citizenweb.tooling.honeyback.core.domain.model.Unit;

import java.math.BigDecimal;

@NoArgsConstructor
public class ProductBuilder implements EntityBuilderService<Product> {

    /* PRODUCT */
    public static String name = "Miel de lavande";
    public static String reference = "M01LAV";
    public static String productDescription = "Un miel de toute beauté";
    public static int quantity = 500;
    public static BigDecimal priceNoVat = new BigDecimal("10.5");
    public static BigDecimal priceWithVat = new BigDecimal("12.7");

    /**
     * Uses a {@link lombok.Builder} to build a {@link Product}
     * @param params Unit, id, Seller
     * @return a {@link Product}
     */
    @Override
    public Product getEntityWithBuilder(Object... params) {
        Unit unit = (Unit) params[0];
        long id = (long) params[1];
        Seller seller = (Seller) params[2];
        return Product.builder()
                .id(id)
                .name(name)
                .reference(reference)
                .description(productDescription)
                .unit(unit)
                .quantity(quantity)
                .unitPriceNoVAT(priceNoVat)
                .unitPriceWithVAT(priceWithVat)
                .seller(seller)
                .build();
    }

    /**
     * Uses a constructor to build a {@link Product}
     * @param params Unit, id, Seller
     * @return a {@link Product}
     */
    @Override
    public Product getEntityWithConstructor(Object... params) {
        Unit unit = (Unit) params[0];
        long id = (long) params[1];
        Seller seller = (Seller) params[2];
        Product product = new Product(name, reference, productDescription, unit, quantity, priceNoVat, priceWithVat, seller);
        product.setId(id);
        return product;
    }
}
