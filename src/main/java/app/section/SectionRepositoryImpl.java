package app.section;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Pavel on 18-Jun-17.
 */
@Transactional
@Repository("sectionRepository")
public class SectionRepositoryImpl implements app.Repository<Section> {
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public Section getById(int id) {
        return (Section) sessionFactory.getCurrentSession().get(Section.class, id);
    }

    @Override
    public List<Section> getAllById(Integer id) {

        return sessionFactory.getCurrentSession().createQuery("from Section s where library_id = :library_id")
                .setParameter("library_id", id).list();
    }

    @Override
    public void save(Section section) {
        sessionFactory.getCurrentSession().saveOrUpdate(section);
    }

    @Override
    public void delete(Section section) {
        sessionFactory.getCurrentSession().delete(section);
    }

}
