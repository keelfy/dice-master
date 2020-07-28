package keelfy.dice_master.model.character;

import keelfy.dice_master.model.source.GameSource;
import lombok.*;
import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Describes character's class.
 *
 * @author keelfy
 */
@Entity
@Table(name = "character_class")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {
        "id", "name"
})
public class CharacterClass implements CharacterModifier {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "hit_dice")
    private Integer hitDice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "source_id",
            referencedColumnName = "id"
    )
    private GameSource source;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "class_attribute",
            joinColumns = @JoinColumn(
                    name = "class_id",
                    referencedColumnName = "id"
            )
    )
    @MapKeyJoinColumn(
            name = "attribute_id",
            referencedColumnName = "id"
    )
    @Column(name = "bonus")
    private Map<Attribute, Integer> attributeBonuses = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "class_abilities",
            joinColumns = @JoinColumn(
                    name = "class_id",
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

    @Override
    public Integer getSpeedModifier() {
        return 0;
    }
}
