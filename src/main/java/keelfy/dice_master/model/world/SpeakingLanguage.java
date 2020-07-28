package keelfy.dice_master.model.world;

import keelfy.dice_master.model.character.race.Race;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Describes language of world.
 *
 * @author keelfy
 */
@Entity
@Table(name = "speaking_language")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = { "id", "name" })
public class SpeakingLanguage {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "speakingLanguages")
    private Set<Race> races = new HashSet<>();
}
