package keelfy.dice_master.repository;

import keelfy.dice_master.model.character.GameCharacter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author keelfy
 */
@Repository
public interface CharacterRepository extends CrudRepository<GameCharacter, Long> { }
