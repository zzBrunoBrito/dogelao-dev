package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bruno on 11/16/16.
 */
public interface GenericDaoInterface <T, I extends Serializable> {

    public T save(T entity);
    public T update(T entity);
    public void remove(I id);
    public List<T> list();
    public T findById(I id);
}
