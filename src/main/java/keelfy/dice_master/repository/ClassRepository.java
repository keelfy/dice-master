package keelfy.dice_master.repository;

import keelfy.dice_master.model.CharacterClass;

import java.util.List;

/**
 * @author keelfy
 */
public interface ClassRepository {

    public void addClass(CharacterClass characterClass);

    public void updateClass(CharacterClass characterClass);

    public void removeClass(int id);

    public CharacterClass getClass(int id);

    public List<CharacterClass> listClasses();

}
