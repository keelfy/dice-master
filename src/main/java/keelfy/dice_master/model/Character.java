package keelfy.dice_master.model;

import javax.persistence.*;

/**
 * @author keelfy
 */
public class Character {

    private int id;

    private String name;
    private Race race;
    private CharacterClass characterClass;
    private String ideology;

    // Dynamic information
    private int level;
    private int hitPoints;
    private int inspiration;
    private int speed;



    // Saving throws

    public int getProficiencyBonus() {
        return 2 + (level <= 4 ? 1 : (level <= 8 ? 2 : (level <= 12 ? 3 : (level <= 16 ? 4 : (level <= 20 ? 5 : 6)))));
    }
}
