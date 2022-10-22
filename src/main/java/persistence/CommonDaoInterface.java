package persistence;

import java.util.List;


/** Interface de métodos comunes */
public interface CommonDaoInterface<T> {


    public void create(final T paramT);

    public void delete(final T paramT);

    public void update (final T paramT);

    public T findById(final Integer id);

    public List<T> findAll();

}
