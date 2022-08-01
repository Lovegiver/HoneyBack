package model;

import lombok.*;

@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Product implements PictureHolder {

    @Getter @Setter @ToString.Include
    private long id;
    @Getter @Setter @ToString.Include
    private String name;
    @Getter @Setter @ToString.Include
    private String reference;
    @Getter @Setter @ToString.Include
    private String description;
    @Getter @Setter @ToString.Include
    private Unit unit;
    @Getter @Setter @ToString.Include
    private int quantity;
    @Getter @Setter @ToString.Include
    private Seller seller;
    @Getter @Setter
    private Picture associatedPicture;

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
        // TODO : implement the other side of the relationship
    }

    @Override
    public void dissociatePicture(Picture picture) {
        this.associatedPicture = null;
        // TODO : implement the other side of the relationship
    }
}
