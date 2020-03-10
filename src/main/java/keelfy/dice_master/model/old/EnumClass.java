package keelfy.dice_master.model.old;

/**
 * @author keelfy
 */
public enum EnumClass {
    FIGHTER("Воин"),
    ROGUE("Плут"),
    WIZARD("Волшебник"),
    BARBARIAN("Варвар"),
    PRIEST("Жрец"),
    RANGER("Следопыт"),
    PALADIN("Паладин"),
    WARLOCK("Колдун"),
    MONK("Монах"),
    BARD("Бард"),
    SORCERER("Чародей"),
    DRUID("Друид");

    private final String localizedName;

    private EnumClass(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getLocalizedName() {
        return localizedName;
    }
}
