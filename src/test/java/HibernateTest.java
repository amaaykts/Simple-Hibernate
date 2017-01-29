import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    @BeforeClass
    public static void createConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Unit-tests-Postgres");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void userTest() {
        User user = new User();
        user.setName("Ivan");
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(user);
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    @AfterClass
    public static void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
