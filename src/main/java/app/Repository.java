package app;

import java.util.List;

/**
 * Created by Pavel on 18-Jun-17.
 */
public interface Repository<T extends Entity> {
    T getById(int id);
    List<T> getAllById(Integer id);
    void save(T entity);
    void delete(T entity);
}
