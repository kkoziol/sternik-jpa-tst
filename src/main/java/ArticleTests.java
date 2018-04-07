import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ArticleTests {

    public static void main(String[] args) throws IOException {

        int id;
        String userId;

        EntityManager em = null;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2-eclipselink");
            em = emf.createEntityManager();

            em.getTransaction().begin();

            UserDetails user = new UserDetails();
            user.setName("kk");
            user.setPassword("kk");
            user.setStatusDate(new Date());
            user.setUserStatus(UserStatus.ACTIVE);

            em.persist(user);
            userId = user.getUserId();

            Article article = new Article();
            // article.setId(1 + (int)(Math.random()*100));
            article.setName("ram");
            article.setPrice(100);
            article.setDescription("DDR3 16GB");
            article.setUser(user);

            em.persist(article);

            id = article.getId();
            System.out.println("Article dostało ID=" + id);

            article = new Article();
            article.setName("CDROM");
            article.setPrice(50);
            article.setDescription("x120");
            article.setUser(user);
            em.persist(article);
            em.getTransaction().commit();

            em.close();
            System.out.println("Persisted");

            System.out.println("kliknij enter");
//            System.in.read();

            em = emf.createEntityManager();
            em.getTransaction().begin();

            Article article2 = em.find(Article.class, id);
            System.out.println("Wyciagniete z H2=" + article2);

            em.getTransaction().commit();

            em.close();
            System.out.println("A teraz bedze kasowanie");

            System.out.println("kliknij enter");
//            System.in.read();

            em = emf.createEntityManager();
            em.getTransaction().begin();

            article2 = em.find(Article.class, id);
            System.out.println("Wyciagniete z H2 do skasowania =" + article2);

            em.remove(article2);

            em.getTransaction().rollback();

            em.getTransaction().begin();

            UserDetails userDetails = em.find(UserDetails.class, userId);

            System.out.println(userDetails);
            System.out.println(userDetails.getArticles());

            em.getTransaction().commit();
            em.close();
            

        } finally {
            if (em != null && em.isOpen()) {
                System.out.println("EM close");
                em.close();
            }
        }
    }
}