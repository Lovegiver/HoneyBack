package model;

import lombok.*;

import java.math.BigDecimal;

@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OrderLine {

    @Getter @Setter @ToString.Include
    private long id;
    @Getter @Setter @ToString.Include
    private Order order;
    @Getter @Setter @ToString.Include
    private User buyer;
    @Getter @Setter @ToString.Include
    private Product product;
    @Getter @Setter @ToString.Include
    private int quantity;
    @Getter @Setter @ToString.Include
    private BigDecimal unitPriceNoVAT;
    @Getter @Setter @ToString.Include
    private BigDecimal totalPriceNoVAT;
    @Getter @Setter @ToString.Include
    private BigDecimal unitPriceWithVAT;
    @Getter @Setter @ToString.Include
    private BigDecimal totalPriceWithVAT;
    @Getter @Setter @ToString.Include
    private BigDecimal applicableVAT;
    @Getter @Setter @ToString.Include
    private BigDecimal applicableDiscount;
    @Getter @Setter @ToString.Include
    private boolean isActive;

}
