package keelfy.dice_master.repository.impl;

import keelfy.dice_master.model.Ability;
import keelfy.dice_master.repository.AbilityRepository;
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
public class AbilityRepositoryImpl implements AbilityRepository {

    private static final Logger logger = LoggerFactory.getLogger(AbilityRepositoryImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAbility(Ability ability) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(ability);
        logger.info("Ability successfully added. Details: " + ability);
    }

    @Override
    public void updateAbility(Ability ability) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(ability);
        logger.info("Ability successfully updated. Details: " + ability);
    }

    @Override
    public void removeAbility(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Ability ability = session.load(Ability.class, new Integer(id));
        if (ability != null) {
            session.delete(ability);
        }
        logger.info("Ability successfully removed. Details: " + ability);
    }

    @Override
    public Ability getAbility(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Ability ability = session.load(Ability.class, new Integer(id));
        logger.info("Ability successfully loaded. Details: " + ability);
        return null;
    }

    @Override
    public List<Ability> listAbilities() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Ability> criteriaQuery = criteriaBuilder.createQuery(Ability.class);
        criteriaQuery.from(Ability.class);
        List<Ability> abilities = session.createQuery(criteriaQuery).list();
        logger.info("List of abilities successfully loaded.");
        return abilities;
    }
}
