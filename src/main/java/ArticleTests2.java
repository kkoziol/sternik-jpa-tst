import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ArticleTests2 {

    public static void main(String[] args) throws IOException {

        EntityManager em = null;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2-eclipselink");
            em = emf.createEntityManager();

            Query query = em.createQuery("SELECT DISTINCT u FROM UserDetails u LEFT JOIN FETCH u.articles ");
            @SuppressWarnings("unchecked")
            List<UserDetails> userDetails = query.getResultList();

            for (UserDetails user : userDetails) {
                System.out.print(user);
                System.out.println("  " + user.getArticles().size());
            }

            em.close();

        } finally {
            if (em != null && em.isOpen()) {
                System.out.println("EM close");
                em.close();

            }
        }
    }
}