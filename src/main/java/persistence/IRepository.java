package persistence;

import java.util.Collection;

public interface IRepository<T> {
    T getByID(int id);
    Collection<T> getAll();
    T create(T entity);
    T update(T entity);
    T delete (T entity);
}
