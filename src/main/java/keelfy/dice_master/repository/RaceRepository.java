package keelfy.dice_master.repository;

import keelfy.dice_master.model.character.race.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author keelfy
 */
@Repository
public interface RaceRepository extends CrudRepository<Race, Long> {
    Race findByName(String name);
}
