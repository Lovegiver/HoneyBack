package model;

import lombok.*;

import javax.persistence.*;
import java.sql.Clob;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "PICTURE")
@DiscriminatorColumn(name = "pic_type")
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Picture {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pic_id")
    @Getter @Setter @ToString.Include
    private long id;
    @Lob
    @Column(name = "pic_picture")
    @Getter @Setter
    private Clob picture;
    /* RELATIONSHIP */
    @OneToOne @JoinColumn(name = "pic_usr_id_owner")
    @Getter @Setter @ToString.Include
    private User owner;


    public Picture(@NonNull Clob picture, @NonNull User user) {
        this.picture = picture;
        this.owner = user;
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
