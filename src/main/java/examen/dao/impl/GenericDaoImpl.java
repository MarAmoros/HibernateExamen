package examen.dao.impl;

import examen.dao.GenericDao;
import examen.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDaoImpl <T,ID extends Serializable> implements GenericDao<T,ID>{

    SessionFactory sessionFactory;

    public GenericDaoImpl() {
        sessionFactory=HibernateUtil.getSessionFactory();
    }

    @Override // always updates with id 0
    public void saveOrUpdate(T entity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
       try {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } catch (Exception exc) {
           System.out.println("rollback failed : saveOrUpdate");
        }
       session.close();
    }

    @Override
    public T get(ID id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        T entity = (T) session.get(getEntityClass(), id);
        transaction.commit();
        try {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } catch (Exception exc) {
            System.out.println("rollback failed : get");
        }
            return entity;


    }

    @Override
    public void delete(ID id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        T entity = (T) session.get(getEntityClass(),id);
        session.delete(entity);
        transaction.commit();
        try{
            if (session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
        }catch (Exception e){
            System.out.println("rollback failed : delete");
        }
        session.close();
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Query query=session.createQuery("SELECT e FROM "+getEntityClass().getName()+" e");
        List<T> entities = query.list();
        session.close();
        return entities;
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
