package at.htl.shoestore;

import at.htl.shoestore.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class InitBean {

    @PersistenceContext
    EntityManager em;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        System.out.println("*** It works ***");

        Product shoe = new Product("Adidas", "Continental 80", 99.99);
        em.persist(shoe);
        em.persist(new Product("Adidas", "Yung-1", 109.99));
    }

    public void tearDown(@Observes @Destroyed(ApplicationScoped.class) Object init) {
        // when app is undeployed
    }
}
