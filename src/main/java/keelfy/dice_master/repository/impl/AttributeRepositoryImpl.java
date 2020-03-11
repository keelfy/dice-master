package keelfy.dice_master.repository.impl;

import keelfy.dice_master.model.Attribute;
import keelfy.dice_master.model.CharacterClass;
import keelfy.dice_master.repository.AttributeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.nio.channels.SeekableByteChannel;
import java.util.List;

/**
 * @author keelfy
 */
public class AttributeRepositoryImpl implements AttributeRepository {

    private static final Logger logger = LoggerFactory.getLogger(AttributeRepositoryImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAttribute(Attribute attribute) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(attribute);
        logger.info("Attribute successfully added. Details: " + attribute);
    }

    @Override
    public void updateAttribute(Attribute attribute) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(attribute);
        logger.info("Attribute successfully updated. Details: " + attribute);
    }

    @Override
    public void removeAttribute(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Attribute attribute = session.load(Attribute.class, new Integer(id));
        if (attribute != null) {
            session.remove(attribute);
        }
        logger.info("Attribute successfully removed. Details: " + attribute);
    }

    @Override
    public Attribute getAttribute(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Attribute attribute = session.load(Attribute.class, new Integer(id));
        logger.info("Attribute successfully loaded. Details: " + attribute);
        return attribute;
    }

    @Override
    public List<Attribute> listAttributes() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Attribute> criteriaQuery = criteriaBuilder.createQuery(Attribute.class);
        criteriaQuery.from(Attribute.class);
        List<Attribute> attributes = session.createQuery(criteriaQuery).list();
        logger.info("List of attributes successfully loaded.");
        return attributes;
    }
}
