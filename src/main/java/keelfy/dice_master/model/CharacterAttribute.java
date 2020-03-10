package keelfy.dice_master.model;

/**
 * @author keelfy
 */
public abstract class CharacterAttribute {

    private int level;

    public abstract String getName();

    public abstract String getLocalizedName();

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
