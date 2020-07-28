package keelfy.dice_master.repository;

import keelfy.dice_master.model.character.CharacterClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author keelfy
 */
@Repository
public interface CharacterClassRepository extends CrudRepository<CharacterClass, Long> {
    CharacterClass findByName(String name);
}
