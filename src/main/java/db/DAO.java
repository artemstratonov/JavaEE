package db;

import java.util.List;

public interface DAO<T, Key> {
    boolean create(T entity);
    T read(Key key);
    boolean update(T entity);
    boolean delete(Integer i);
    List<T> findAll();
}
