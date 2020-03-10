package keelfy.dice_master.repository.impl;

import keelfy.dice_master.model.CharacterClass;
import keelfy.dice_master.repository.ClassRepository;
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
public class ClassRepositoryImpl implements ClassRepository {

    private static final Logger logger = LoggerFactory.getLogger(ClassRepositoryImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addClass(CharacterClass characterClass) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(characterClass);
        logger.info("Class successfully added. Details: " + characterClass);
    }

    @Override
    public void updateClass(CharacterClass characterClass) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(characterClass);
        logger.info("Class successfully updated. Details: " + characterClass);
    }

    @Override
    public void removeClass(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CharacterClass characterClass = session.load(CharacterClass.class, new Integer(id));
        if (characterClass != null) {
            session.remove(characterClass);
        }
        logger.info("Class successfully removed. Details: " + characterClass);
    }

    @Override
    public CharacterClass getClass(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CharacterClass characterClass = session.load(CharacterClass.class, new Integer(id));
        logger.info("Class successfully loaded. Details: " + characterClass);
        System.out.println(characterClass);
        return characterClass;
    }

    @Override
    public List<CharacterClass> listClasses() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CharacterClass> criteriaQuery = criteriaBuilder.createQuery(CharacterClass.class);
        criteriaQuery.from(CharacterClass.class);
        List<CharacterClass> classes = session.createQuery(criteriaQuery).list();
        logger.info("List of classes successfully loaded.");
        return classes;
    }
}
