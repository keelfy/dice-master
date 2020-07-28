package keelfy.dice_master.model.world;

import keelfy.dice_master.model.Game;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Describes abstract world in game.
 *
 * @author keelfy
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name", "shortStory"})
public class World {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "short_story")
    private String shortStory;

    @Column(name = "long_story")
    private String longStory;

    @OneToMany(mappedBy = "world", fetch = FetchType.LAZY)
    private Set<Game> games = new HashSet<>();
}
