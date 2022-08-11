package model;

import lombok.*;

import java.sql.Blob;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Picture {

    @Getter @Setter @ToString.Include
    private long id;
    @Getter @Setter
    private Blob picture;
    @Getter @Setter @ToString.Include
    private User owner;
    @Getter @Setter
    private Set<PictureHolder> pictureHolders = new LinkedHashSet<>();

    public Picture(@NonNull Blob picture, @NonNull User user) {
        this.picture = picture;
        this.owner = user;
    }

    public void associatePictureHolder(@NonNull PictureHolder holder) {
        this.pictureHolders.add(holder);
        holder.associatePicture(this);
    }

    public void removeAssociatedPictureHolder(@NonNull PictureHolder holder) {
        this.pictureHolders.remove(holder);
        holder.dissociatePicture(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Picture)) return false;
        Picture picture1 = (Picture) o;
        return id == picture1.id && picture.equals(picture1.picture) && owner.equals(picture1.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, picture, owner);
    }
}
