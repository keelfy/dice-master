package keelfy.dice_master.repository;

import keelfy.dice_master.model.source.GameSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author keelfy
 */
@Repository
public interface GameSourceRepository extends CrudRepository<GameSource, Long> {}
