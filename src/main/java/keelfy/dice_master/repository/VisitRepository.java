package keelfy.dice_master.repository;

import keelfy.dice_master.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author keelfy
 */
@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {}
