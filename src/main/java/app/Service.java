package app;

import java.util.List;

/**
 * Created by Pavel on 18-Jun-17.
 */
public interface Service<T extends Entity> {
    T findById(int id);
    List<T> findAllById(Integer id);
    void save(T entity);
    void delete(T entity);
}
