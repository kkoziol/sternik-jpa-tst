import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ArticleTests2 {

    public static void main(String[] args) throws IOException {

        EntityManager em = null;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2-eclipselink");
            em = emf.createEntityManager();

            // Query query = em.createQuery("SELECT DISTINCT u FROM UserDetails u LEFT JOIN
            // FETCH u.articles ");
            TypedQuery<UserDetails> query = em.createNamedQuery("UserDetails.findAll",UserDetails.class);

            List<UserDetails> userDetails = query.getResultList();
            em.clear();
            System.out.println("----------------------------------------------------------------------------------");
            for (UserDetails user : userDetails) {
                em.detach(user);                
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