package keelfy.dice_master.model.character;

import keelfy.dice_master.model.Game;
import keelfy.dice_master.model.character.race.Race;
import keelfy.dice_master.model.world.SpeakingLanguage;
import keelfy.dice_master.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Describes in-game character.
 *
 * @author keelfy
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name", "shortStory"})
public class GameCharacter {

    @Id
    @GeneratedValue
    private Long id;

    /** @see CharacterProgressionType */
    private CharacterProgressionType progressionType;

    /** @see HitPointType */
    private HitPointType hitPointType;

    /** @see CharacterPrivacyType */
    private CharacterPrivacyType privacyType;

    private String name;

    /** Short story to display on listings UI. */
    @Column(name = "short_story")
    private String shortStory;

    /** Full story to display on details UI. */
    private String story;

    /** Lazy-loaded information about owner. */
    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private CharacterClass characterClass;

    /** same as health points. */
    private Integer hits;

    /** Distance of movement in fights. */
    private Short speed;

    /** Current level of character. */
    private Short level;

    /** Amount of money in character's inventory. */
    private Integer money;

    /**
     * Stores collection of languages a character can speak.
     * */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "character_language",
            joinColumns = @JoinColumn(
                    name = "character_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "speaking_language_id",
                    referencedColumnName = "id"
            )
    )
    private Set<SpeakingLanguage> languages = new HashSet<>();

    /**
     * List of games where character persists.
     * */
    @ManyToMany(
            mappedBy = "characters",
            fetch = FetchType.LAZY
    )
    private Set<Game> games = new HashSet<>();
}
