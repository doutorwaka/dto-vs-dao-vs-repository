package dto.dao.repositories.daos;

import java.util.List;

/**
 * Data Access Object - DAO
 */
public interface DaoInterface<T> {

    public T getById(String id);

    public List<T> getAll();

    public T create(T anEntity);

    public T update(T anEntity);

    public void delete(String id);
}
