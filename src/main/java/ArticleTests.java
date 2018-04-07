import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ArticleTests {

    public static void main(String[] args) throws IOException {

        EntityManager em = null;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2-eclipselink");
            em = emf.createEntityManager();
 
            
        } finally {
            if (em != null && em.isOpen()) {
                System.out.println("hi");
                em.close();
            }
        }
    }
}