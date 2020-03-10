package keelfy.dice_master.model;

import javax.persistence.*;

/**
 * @author keelfy
 */
//@Entity
//@Table(name = "characters")
public class Character {

//    @Id
//    @Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name = "NAME")
    private String name;
//    @Column(name = "RACE_ID")
    private int raceId;
//    @Column(name = "CLASS_ID")
    private int classId;
//    @Column(name = "IDEOLOGY")
    private String ideology;

    // Dynamic information
    private int level;
    private int hitPoints;
    private int hitDice;
    private int inspiration;
    private int speed;

    // Attributes
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    // Abilities
    private int athletics;

    private int acrobatics;
    private int sleightOfHand;
    private int stealth;

    private int arcana;
    private int history;
    private int investigation;
    private int nature;
    private int religion;

    private int animalHandling;
    private int insight;
    private int medicine;
    private int perception;
    private int survival;

    private int deception;
    private int intimidation;
    private int performance;
    private int persuasion;



    // Saving throws

    public int getProficiencyBonus() {
        return 2 + (level <= 4 ? 1 : (level <= 8 ? 2 : (level <= 12 ? 3 : (level <= 16 ? 4 : (level <= 20 ? 5 : 6)))));
    }
}
