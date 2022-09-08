package model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public abstract class OrderItemContainer implements Orderable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oic_id")
    private long id;
    @Column(name = "oic_no_Vat_amount")
    @Getter @Setter @ToString.Include
    BigDecimal totalAmountNoVAT;
    @Column(name = "oic_with_Vat_amount")
    @Getter @Setter @ToString.Include
    private BigDecimal totalAmountWithVAT;

}
