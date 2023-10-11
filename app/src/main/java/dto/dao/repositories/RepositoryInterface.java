package dto.dao.repositories;

import java.util.List;

public interface RepositoryInterface<T> {

    public T getById(String id);

    public List<T> getAll();

    public T create(T anEntity);

    public T update(T anEntity);

    public void delete(String id);
    
}
