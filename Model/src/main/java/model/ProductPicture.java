package model;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue("PRODUCT")
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ProductPicture extends Picture {

    /* RELATIONSHIP */
    @OneToMany(mappedBy = "associatedPicture")
    @Getter @Setter @ToString.Include
    private List<Product> products = new ArrayList<>();

    public ProductPicture(@NonNull Clob picture, @NonNull User user) {
        super(picture, user);
    }

    /**
     * Associates a Product to this Picture
     * @param holder the Product to be associated
     */
    public void associatePictureHolder(@NonNull PictureHolder holder) {
        this.products.add((Product) holder);
        holder.associatePicture(this);
    }

    /**
     * Dissociates a Product from this Picture
     * @param holder the Product to be dissociated
     */
    public void removeAssociatedPictureHolder(@NonNull PictureHolder holder) {
        this.products.remove((Product) holder);
        holder.dissociatePicture(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductPicture)) return false;
        if (!super.equals(o)) return false;
        ProductPicture that = (ProductPicture) o;
        return products.equals(that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), products);
    }
}
