package persistence;

import model.LivingElements.Hero;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

public class RepositoryImpl<T> implements IRepository<T> {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();

    Class<T> type;

    @Override
    public T getByID(int id) {
        return null;
    }

    @Override
    public Collection<T> getAll() {
        Transaction transaction = session.beginTransaction();
        Collection<T> heroes = session.createCriteria(Hero.class).list();
        transaction.commit();
        return heroes;
    }

    @Override
    public T create(T entity) {
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        return entity;
    }

    @Override
    public T update(T entity) {
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        return entity;
    }

    @Override
    public T delete(T entity) {
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        return null;
    }
}
