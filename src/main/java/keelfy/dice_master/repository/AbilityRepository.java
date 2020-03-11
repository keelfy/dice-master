package keelfy.dice_master.repository;

import java.util.List;
import keelfy.dice_master.model.Ability;

/**
 * @author keelfy
 */
public interface AbilityRepository {

    public void addAbility(Ability ability);

    public void updateAbility(Ability ability);

    public void removeAbility(int id);

    public Ability getAbility(int id);

    public List<Ability> listAbilities();
}
