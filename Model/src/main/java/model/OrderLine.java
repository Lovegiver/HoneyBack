package model;

import enums.OrderlineStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OrderLine implements Orderable {

    @Getter @Setter @ToString.Include
    private long id;
    @Getter @Setter @ToString.Include
    private OrderlineStatus status;
    @Getter @Setter @ToString.Include
    private LocalDateTime creationDate;
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
    @ToString.Include
    private BigDecimal totalAmountNoVAT;
    @Getter @Setter @ToString.Include
    private BigDecimal unitPriceWithVAT;
    @ToString.Include
    private BigDecimal totalAmountWithVAT;
    @Getter @Setter @ToString.Include
    private BigDecimal applicableVAT;
    @Getter @Setter @ToString.Include
    private BigDecimal applicableDiscount;
    @Getter @Setter @ToString.Include
    private boolean isActive;

    /**
     * @return
     */
    @Override
    public BigDecimal getTotalAmountNoVAT() {
        BigDecimal amount = this.unitPriceNoVAT.multiply(this.applicableDiscount).multiply(new BigDecimal(this.quantity));
        this.totalAmountNoVAT = amount;
        return amount;
    }

    /**
     * @return
     */
    @Override
    public BigDecimal getTotalAmountWithVAT() {
        BigDecimal amount = this.getTotalAmountNoVAT().multiply(this.applicableVAT);
        this.totalAmountWithVAT = amount;
        return amount;
    }



}
