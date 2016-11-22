package dao;


import dao.interfaces.GenericDaoInterface;
import dao.util.Fabrica;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractGenericDao<T, I extends Serializable> implements GenericDaoInterface<T, I> {

    @Inject
    protected EntityManager entityManager;

    private Class<T> persistedClass;

    protected AbstractGenericDao() {

    }

    protected AbstractGenericDao(Class<T> persistedClass) {
        this();
        this.persistedClass = persistedClass;
    }


    public T save(T entity) {
        EntityManager em = Fabrica.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        return entity;
    }

    public T update(T entity) {
        EntityManager em = Fabrica.getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.flush();
        em.getTransaction().commit();
        return entity;
    }

    public void remove(Serializable id) {
        EntityManager em = Fabrica.getEntityManager();
        em.getTransaction().begin();
        T entity = findById(id);
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
    }

    public List<T> list() {
        EntityManager em = Fabrica.getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        return em.createQuery(query).getResultList();
    }

    public T findById(Serializable id) {
        EntityManager em = Fabrica.getEntityManager();
        em.getTransaction().begin();
        T entity = em.find(persistedClass, id);
        em.close();
        return entity;
    }
}