package keelfy.dice_master.model;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "SPEED")
    private int basicSpeed;

    @ElementCollection
    @CollectionTable(name = "race_languages", joinColumns = @JoinColumn(name = "RACE_ID"))
    @Column(name = "LANGUAGE")
    private List<String> languages;

    // Attribute bonuses
    @Column(name = "STRENGTH")
    private int strength;
    @Column(name = "DEXTERITY")
    private int dexterity;
    @Column(name = "CONSTITUTION")
    private int constitution;
    @Column(name = "INTELLIGENCE")
    private int intelligence;
    @Column(name = "WISDOM")
    private int wisdom;
    @Column(name = "CHARISMA")
    private int charisma;

    // Ability bonuses
    @Column(name = "ATHLETICS")
    private int athletics;

    @Column(name = "ACROBATICS")
    private int acrobatics;
    @Column(name = "SLEIGHT_OF_HAND")
    private int sleightOfHand;
    @Column(name = "STEALTH")
    private int stealth;

    @Column(name = "ARCANA")
    private int arcana;
    @Column(name = "HISTORY")
    private int history;
    @Column(name = "INVESTIGATION")
    private int investigation;
    @Column(name = "NATURE")
    private int nature;
    @Column(name = "RELIGION")
    private int religion;

    @Column(name = "ANIMAL_HANDLING")
    private int animalHandling;
    @Column(name = "INSIGHT")
    private int insight;
    @Column(name = "MEDICINE")
    private int medicine;
    @Column(name = "PERCEPTION")
    private int perception;
    @Column(name = "SURVIVAL")
    private int survival;

    @Column(name = "DECEPTION")
    private int deception;
    @Column(name = "INTIMIDATION")
    private int intimidation;
    @Column(name = "PERFORMANCE")
    private int performance;
    @Column(name = "PERSUASION")
    private int persuasion;

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

    public int getBasicSpeed() {
        return basicSpeed;
    }

    public void setBasicSpeed(int basicSpeed) {
        this.basicSpeed = basicSpeed;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public int getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(int acrobatics) {
        this.acrobatics = acrobatics;
    }

    public int getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(int sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getArcana() {
        return arcana;
    }

    public void setArcana(int arcana) {
        this.arcana = arcana;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getInvestigation() {
        return investigation;
    }

    public void setInvestigation(int investigation) {
        this.investigation = investigation;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(int animalHandling) {
        this.animalHandling = animalHandling;
    }

    public int getInsight() {
        return insight;
    }

    public void setInsight(int insight) {
        this.insight = insight;
    }

    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getSurvival() {
        return survival;
    }

    public void setSurvival(int survival) {
        this.survival = survival;
    }

    public int getDeception() {
        return deception;
    }

    public void setDeception(int deception) {
        this.deception = deception;
    }

    public int getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(int intimidation) {
        this.intimidation = intimidation;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basicSpeed=" + basicSpeed +
                ", languages=" + languages +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                ", athletics=" + athletics +
                ", acrobatics=" + acrobatics +
                ", sleightOfHand=" + sleightOfHand +
                ", stealth=" + stealth +
                ", arcana=" + arcana +
                ", history=" + history +
                ", investigation=" + investigation +
                ", nature=" + nature +
                ", religion=" + religion +
                ", animalHandling=" + animalHandling +
                ", insight=" + insight +
                ", medicine=" + medicine +
                ", perception=" + perception +
                ", survival=" + survival +
                ", deception=" + deception +
                ", intimidation=" + intimidation +
                ", performance=" + performance +
                ", persuasion=" + persuasion +
                '}';
    }
}
