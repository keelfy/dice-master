package keelfy.dice_master.model.old;

/**
 * @author keelfy
 */
public enum EnumRace {
    HUMAN("Человек"),
    ELF("Эльф"),
    HELF_ELF("Полуэльф"),
    DWARF("Дварф"),
    DRAGONBORN("Драконорожденный"),
    TIEFLING("Тифлинг"),
    GENASI("Генаси"),
    HALFLING("Полурослик"),
    HALF_ORC("Полуорк"),
    GNOME("Гном"),
    GOLIATH("Голиаф"),
    AARAKOCRA("Ааракокра"),
    AASIMAR("Аазимар");

    private final String localizedName;

    private EnumRace(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getLocalizedName() {
        return localizedName;
    }
}
