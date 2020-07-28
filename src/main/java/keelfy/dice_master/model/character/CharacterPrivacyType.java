package keelfy.dice_master.model.character;

/**
 * Describes accessibility of game character.
 *
 * @author keelfy
 */
public enum CharacterPrivacyType {

    /** Only owner can see the details. */
    PRIVATE,

    /** Only owner and game members can see the details. */
    SEMIPRIVATE,

    /** Everyone can see the details. */
    PUBLIC;
}
