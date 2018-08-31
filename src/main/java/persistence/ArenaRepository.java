package persistence;

import model.mapElements.Arena;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.beans.Transient;
import java.util.Collection;

public class ArenaRepository implements IRepository<Arena> {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();

    @Override
    public Arena getByID(int id) {
        return null;
    }

    @Override
    public Collection<Arena> getAll() {
        return null;
    }

    @Override
    public Arena create(Arena entity) {
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();

        System.out.println("The profile chosen is: "+entity.getHero().getName());
        return entity;
    }

    @Override
    public Arena update(Arena entity) {
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        return entity;
    }

    @Override
    public Arena delete(Arena entity) {
        return null;
    }
}
