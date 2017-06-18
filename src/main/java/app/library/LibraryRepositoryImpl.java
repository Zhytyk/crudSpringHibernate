package app.library;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Pavel on 17-Jun-17.
 */

@Transactional
@Repository("libraryRepository")
public class LibraryRepositoryImpl implements app.Repository<Library> {
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public Library getById(int id) {
        return (Library) sessionFactory.getCurrentSession().get(Library.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Library> getAllById(Integer id) {
        return sessionFactory.getCurrentSession().createQuery("from Library l").list();
    }

    @Override
    @Transactional
    public void save(Library library) {
        sessionFactory.getCurrentSession().saveOrUpdate(library);
    }

    @Override
    @Transactional
    public void delete(Library library) {
        sessionFactory.getCurrentSession().delete(library);
    }
}
