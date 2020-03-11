package keelfy.dice_master.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * @author keelfy
 */
@Entity
@Table(name = "races")
public class Race {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SPEED")
    private int speedModifier;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "race_languages", joinColumns = @JoinColumn(name = "RACE_ID", referencedColumnName = "ID"))
    @Column(name = "LANGUAGE_ID")
    private List<Integer> languages;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "race_attribute_bonuses", joinColumns = @JoinColumn(name = "RACE_ID", referencedColumnName = "ID"))
    @MapKeyJoinColumn(name = "ATTRIBUTE_ID")
    @Column(name = "BONUS")
    private Map<Attribute, Integer> attributeBonuses;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "race_ability_bonuses", joinColumns = @JoinColumn(name = "RACE_ID", referencedColumnName = "ID"))
    @MapKeyJoinColumn(name = "ABILITY_ID")
    @Column(name = "BONUS")
    private Map<Ability, Integer> abilityBonuses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSpeedModifier() {
        return speedModifier;
    }

    public void setSpeedModifier(int speedModifier) {
        this.speedModifier = speedModifier;
    }

    public List<Integer> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Integer> languages) {
        this.languages = languages;
    }

    public Map<Attribute, Integer> getAttributeBonuses() {
        return attributeBonuses;
    }

    public void setAttributeBonuses(Map<Attribute, Integer> attributeBonuses) {
        this.attributeBonuses = attributeBonuses;
    }

    public Map<Ability, Integer> getAbilityBonuses() {
        return abilityBonuses;
    }

    public void setAbilityBonuses(Map<Ability, Integer> abilityBonuses) {
        this.abilityBonuses = abilityBonuses;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basicSpeed=" + speedModifier +
                ", languages=" + languages +
                ", attributeBonuses=" + attributeBonuses +
                ", abilityBonuses=" + abilityBonuses +
                '}';
    }
}
