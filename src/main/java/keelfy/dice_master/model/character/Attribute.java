package keelfy.dice_master.model.character;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Describes character's attribute.
 *
 * @author keelfy
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name"})
public class Attribute {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /**
     * Stores all child abilities.
     * */
    @OneToMany(
            mappedBy = "parentAttribute",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Ability> abilities = new ArrayList<>();

}
