package keelfy.dice_master.model.character;

import keelfy.dice_master.model.character.CharacterModifier;
import keelfy.dice_master.model.character.GameCharacter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author keelfy
 */
@EqualsAndHashCode(of = "id")
@ToString(of = {
        "id",
        "name"
})
public abstract class Trait implements CharacterModifier {

    private Long id;

    private String name;

    public abstract void process(GameCharacter character);

    public Integer getSpeedModifier() {
        return 0;
    }

    public Integer getAbilityModifier(Ability ability) {
        return 0;
    }

    public Integer getAttributeModifier(Attribute attribute) {
        return 0;
    }
}
