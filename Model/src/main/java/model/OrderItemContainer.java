package model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public abstract class OrderItemContainer implements Orderable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hld_id")
    private long id;
    @Column(name = "hld_no_Vat_amount")
    @Setter @ToString.Include
    BigDecimal totalAmountNoVAT;
    @Column(name = "hld_with_Vat_amount")
    @Setter @ToString.Include
    private BigDecimal totalAmountWithVAT;

}
