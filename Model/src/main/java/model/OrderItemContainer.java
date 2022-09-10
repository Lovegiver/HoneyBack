package model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@MappedSuperclass
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@SuperBuilder
public abstract class OrderItemContainer implements Orderable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oic_id")
    @Getter @Setter @ToString.Include
    private long id;
    @Column(name = "oic_no_Vat_amount")
    @Getter @Setter @ToString.Include
    BigDecimal totalAmountNoVAT;
    @Column(name = "oic_with_Vat_amount")
    @Getter @Setter @ToString.Include
    BigDecimal totalAmountWithVAT;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemContainer that = (OrderItemContainer) o;
        return id == that.id && Objects.equals(totalAmountNoVAT, that.totalAmountNoVAT)
                && Objects.equals(totalAmountWithVAT, that.totalAmountWithVAT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalAmountNoVAT, totalAmountWithVAT);
    }
}
