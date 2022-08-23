package model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Order implements Orderable {

    @Getter @Setter
    private Collection<OrderLine> orderLines;
    @Getter @Setter @ToString.Include
    private Seller seller;
    @ToString.Include
    private BigDecimal totalAmountNoVAT;
    @ToString.Include
    private BigDecimal totalAmountWithVAT;
    private boolean isSharedOrder;

    /**
     * @return
     */
    @Override
    public BigDecimal getTotalAmountNoVAT() {
        AtomicReference<BigDecimal> amount = new AtomicReference<>(BigDecimal.ZERO);
        this.orderLines.forEach(line -> {
            amount.set(amount.get().add(line.getTotalAmountNoVAT()));
        });
        this.totalAmountNoVAT = amount.get();
        return amount.get();
    }

    /**
     * @return
     */
    @Override
    public BigDecimal getTotalAmountWithVAT() {
        AtomicReference<BigDecimal> amount = new AtomicReference<>(BigDecimal.ZERO);
        this.orderLines.forEach(line -> {
            amount.set(amount.get().add(line.getTotalAmountWithVAT()));
        });
        this.totalAmountNoVAT = amount.get();
        return amount.get();
    }
}
