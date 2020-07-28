package keelfy.dice_master.model.character;

/**
 * @author keelfy
 */
public interface CharacterModifier {

    Integer getAbilityModifier(Ability ability);

    Integer getAttributeModifier(Attribute attribute);

    Integer getSpeedModifier();

}
