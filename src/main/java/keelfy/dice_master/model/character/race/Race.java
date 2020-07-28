package keelfy.dice_master.model.character.race;

import keelfy.dice_master.model.character.Ability;
import keelfy.dice_master.model.character.Attribute;
import keelfy.dice_master.model.character.CharacterModifier;
import keelfy.dice_master.model.character.Trait;
import keelfy.dice_master.model.source.GameSource;
import keelfy.dice_master.model.world.SpeakingLanguage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.*;

/**
 * Describes world race.
 *
 * @author keelfy
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {
        "id",
        "specificationName",
        "name"
})
public class Race implements CharacterModifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "specification_name")
    @ColumnDefault("")
    private String specificationName;

    /**
     * Default speed modifier of 30.
     */
    @Column(name = "speed_modifier")
    @ColumnDefault("0")
    private Integer speedModifier;

    /**
     * List of race traits.
     * Stored in table named 'race_trait' like 'race_id' + 'trait_id'.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "race_trait",
            joinColumns = @JoinColumn(
                    name = "race_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "trait_id",
                    referencedColumnName = "id"
            )
    )
    private List<Trait> traits = new ArrayList<>();

    /**
     * Reference to {@link GameSource} that adds this race.
     * Stored in column 'source_id' of this entity table.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "source_id",
            referencedColumnName = "id"
    )
    private GameSource source;

    /**
     * Reference to parent of this sub-race.
     * Stored in column 'parent_race_id' of entity table.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "parent_race_id",
            referencedColumnName =  "id"
    )
    private Race parentRace = null;

    /**
     * List of references to sub-races.
     * Parent stored in {@link Race} as it's id.
     */
    @OneToMany(
            mappedBy = "parentRace",
            fetch = FetchType.LAZY
    )
    private List<Race> subRaces = new ArrayList<>();

    /**
     * List of references to languages spoken by this race.
     * Contains in table named 'race_language' like 'race_id' + 'speaking_language_id'.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "race_language",
            joinColumns = @JoinColumn(
                    name = "race_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "speaking_language_id",
                    referencedColumnName = "id"
            )
    )
    private List<SpeakingLanguage> speakingLanguages = new ArrayList<>();

    /**
     * Map of specific attributes modifier.
     * Stored in table 'race_attribute' like 'race_id' + 'attribute_id' + 'bonus'.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "race_attribute",
            joinColumns = @JoinColumn(
                    name = "race_id",
                    referencedColumnName = "id"
            )
    )
    @MapKeyJoinColumn(
            name = "attribute_id",
            referencedColumnName = "id"
    )
    @Column(name = "bonus")
    private Map<Attribute, Integer> attributeBonuses = new HashMap<>();

    /**
     * Map of specific abilities modifier.
     * Stored in table 'race_ability' like 'race_id' + 'ability_id' + 'bonus'.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "race_ability",
            joinColumns = @JoinColumn(
                    name = "race_id",
                    referencedColumnName = "id"
            )
    )
    @MapKeyJoinColumn(
            name = "ability_id",
            referencedColumnName = "id"
    )
    @Column(name = "bonus")
    private Map<Ability, Integer> abilityBonuses = new HashMap<>();

    @Override
    public Integer getAbilityModifier(Ability ability) {
        return this.abilityBonuses.get(ability);
    }

    @Override
    public Integer getAttributeModifier(Attribute attribute) {
        return this.attributeBonuses.get(attribute);
    }
}
