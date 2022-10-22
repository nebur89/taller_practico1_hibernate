package persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import persistence.*;
import services.*;
import model.*;

import org.hibernate.Session;

/* Implementacion de metodos comomunes*/
public abstract class CommonDaoImplement<T extends AbstractEntity> implements CommonDaoInterface<T> {

    private Class<T> entityClass;

    //Session de conexion BD
    private Session session;


    @SuppressWarnings("unchecked")
    public CommonDaoImplement(Session session) {
        setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        this.session = session;
    }

    //Implementación del método Create
    @Override
    public void create(final T paramT) {

        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }
        session.save(paramT);
        session.flush();
        session.getTransaction().commit();
    }

    //Implementación del método Delete
    @Override
    public void delete(final T paramT) {

        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }
        session.delete(paramT);
        session.getTransaction().commit();
    }

    //Implementación del método Update
    @Override
    public void update(final T paramT) {

        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }
        session.saveOrUpdate(paramT);
        session.getTransaction().commit();
    }

    //Implementación del método findById
    @Override
    public T findById(final Integer id) {

        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }

         return session.get(this.entityClass, id);

    }

    //Implementación del método findAll
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {

        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }

        List<T> lista = session.createQuery("FROM " + this.entityClass.getName()).list();

        return lista;

    }


    public Class<T> getEntityClass() {
        return entityClass;
    }


    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }





}
