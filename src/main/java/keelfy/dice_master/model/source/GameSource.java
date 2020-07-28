package keelfy.dice_master.model.source;

import keelfy.dice_master.model.character.CharacterClass;
import keelfy.dice_master.model.character.race.Race;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Describes D&D source.
 *
 * @author keelfy
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name"})
@Table(name = "game_source")
public class GameSource {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(
            mappedBy = "source",
            fetch = FetchType.LAZY
    )
    private Set<Race> races = new HashSet<>();

    @OneToMany(
            mappedBy = "source",
            fetch = FetchType.LAZY
    )
    private Set<CharacterClass> characterClasses = new HashSet<>();
}
