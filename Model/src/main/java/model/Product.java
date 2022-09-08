package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Product implements PictureHolder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pdt_id")
    @Getter @Setter @ToString.Include
    private long id;
    @Column(name = "pdt_name")
    @Getter @Setter @ToString.Include
    private String name;
    @Column(name = "pdt_reference")
    @Getter @Setter @ToString.Include
    private String reference;
    @Column(name = "pdt_description")
    @Getter @Setter @ToString.Include
    private String description;
    @Column(name = "pdt_unit") @Enumerated(EnumType.STRING)
    @Getter @Setter @ToString.Include
    private Unit unit;
    @Column(name = "pdt_quantity")
    @Getter @Setter @ToString.Include
    private int quantity;

    /* RELATIONSHIP */
    /** The product's seller */
    @ManyToOne @JoinColumn(name = "pdt_usr_id_seller")
    @Getter @Setter @ToString.Include
    private Seller seller;
    /** The product's picture */
    @ManyToOne @JoinColumn(name = "pdt_pic_id")
    @Getter @Setter
    private Picture associatedPicture;
    /** The order lines where this product may be found */
    @OneToMany(mappedBy = "product")
    @Getter @Setter @ToString.Include
    private List<OrderItem> orderItems;

    public Product(@NonNull String name, @NonNull String reference, String description, @NonNull Unit unit,
                   @NonNull int quantity, @NonNull Seller seller) {
        this.name = name;
        this.reference = reference;
        this.description = description;
        this.unit = unit;
        this.quantity = quantity;
        this.seller = seller;
    }

    @Override
    public void associatePicture(Picture picture) {
        this.associatedPicture = picture;
    }

    @Override
    public void dissociatePicture(Picture picture) {
        this.associatedPicture = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id && quantity == product.quantity && name.equals(product.name) && reference.equals(product.reference) && unit.equals(product.unit) && seller.equals(product.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, reference, unit, quantity, seller);
    }
}
