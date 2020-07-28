package keelfy.dice_master.model.character;

/**
 * Describes type of getting hit point on level-up.
 *
 * @author keelfy
 */
public enum HitPointType {

    /** Hit points added manually (if you want to roll a dice to receive extra hit point) */
    MANUAL,

    /** Hit points adds automatically using formulas. */
    AUTOMATIC;

}
