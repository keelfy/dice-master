package keelfy.dice_master.model;

/**
 * @author keelfy
 */
public class Character {

    private int id;

    private String name;
    private Race race;
    private CharacterClass characterClass;
    private String ideology;

    private int level;
    private int hitPoints;
    private int inspiration;

    /**
     * Calculates proficiency bonus depends on character's level
     * @return actual character's level
     * */
    public int getProficiencyBonus() {
        return 2 + (level <= 4 ? 1 : (level <= 8 ? 2 : (level <= 12 ? 3 : (level <= 16 ? 4 : (level <= 20 ? 5 : 6)))));
    }

    /**
     * Calculates speed of character depends on character's stats
     * @return actual character's speed
     * */
    public int getSpeed() {
        return 30 + race.getSpeedModifier();
    }
}
