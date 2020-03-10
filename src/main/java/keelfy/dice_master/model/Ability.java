package keelfy.dice_master.model;

import javax.persistence.*;

/**
 * @author keelfy
 */
@Entity
@Table(name = "abilities")
public class Ability {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BASE_ATTRIBUTE")
    private int baseAttribute;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseAttribute() {
        return baseAttribute;
    }

    public void setBaseAttribute(int baseAttribute) {
        this.baseAttribute = baseAttribute;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "name='" + name + '\'' +
                ", baseAttribute=" + baseAttribute +
                '}';
    }
}
