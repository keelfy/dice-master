package keelfy.dice_master.repository.impl;

import keelfy.dice_master.model.Race;
import keelfy.dice_master.repository.RaceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @author keelfy
 */
@Repository
public class RaceRepositoryImpl implements RaceRepository {

    private static final Logger logger = LoggerFactory.getLogger(RaceRepositoryImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addRace(Race race) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(race);
        logger.info("Race successfully added. Details: " + race);
    }

    @Override
    public void updateRace(Race race) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(race);
        logger.info("Race successfully update. Details: " + race);
    }

    @Override
    public void removeRace(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Race race = (Race) session.load(Race.class, new Integer(id));
        if (race != null) {
            session.delete(race);
        }
        logger.info("Race successfully deleted. Details: " + race);
    }

    @Override
    public Race getRace(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Race race = (Race) session.load(Race.class, new Integer(id));
        logger.info("Race successfully loaded. Details: " + race);
        return race;
    }

    @Override
    public List<Race> listRaces() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Race> criteriaQuery = criteriaBuilder.createQuery(Race.class);
        criteriaQuery.from(Race.class);
        List<Race> races = session.createQuery(criteriaQuery).list();
        logger.info("List of races successfully loaded.");
        return races;
    }
}
