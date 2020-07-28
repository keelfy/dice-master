package keelfy.dice_master.repository;

import keelfy.dice_master.model.world.SpeakingLanguage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author keelfy
 */
@Repository
public interface SpeakingLanguageRepository extends CrudRepository<SpeakingLanguage, Long> {}
