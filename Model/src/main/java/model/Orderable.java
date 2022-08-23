package model;

import java.math.BigDecimal;

/**
 * Methods to compute the total amount of an {@link OrderLine} or an {@link Order}
 */
public interface Orderable {
    BigDecimal getTotalAmountNoVAT();
    BigDecimal getTotalAmountWithVAT();
}
