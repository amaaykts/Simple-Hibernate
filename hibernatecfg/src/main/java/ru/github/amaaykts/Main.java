package ru.github.amaaykts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.github.amaaykts.model.Item;

public class Main {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("Table");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();
        session.save(item);
        session.flush();

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
