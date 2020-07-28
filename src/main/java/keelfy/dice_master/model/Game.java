package keelfy.dice_master.model;

import keelfy.dice_master.model.character.GameCharacter;
import keelfy.dice_master.model.world.World;
import keelfy.dice_master.model.user.User;
import lombok.*;

import java.util.*;
import javax.persistence.*;

/**
 * Describes D&D game.
 *
 * @author keelfy
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@ToString(of = {"id", "name", "world"})
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    /** Simply name of game. */
    private String name;

    /** Whether money have weight in inventory of any character. */
    private boolean moneyHasWeight;

    /** Stores world of game into `world_id` field. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "world_id")
    private World world;

    /** Stores users and their roles into `game_user_role` table. */
    @ElementCollection(
            fetch = FetchType.LAZY,
            targetClass = GameRole.class
    )
    @CollectionTable(
            name = "game_user_role",
            joinColumns = @JoinColumn(
                    name = "game_id",
                    referencedColumnName = "id"
            )
    )
    @MapKeyJoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    @Column(name = "role_id")
    private Map<User, GameRole> users = new HashMap<>();

    /**
     * Stores game's characters into `character_game` table.
     * */
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "character_game",
            joinColumns = @JoinColumn(
                    name = "game_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "character_id",
                    referencedColumnName = "id"
            )
    )
    private Set<GameCharacter> characters = new HashSet<>();
}
