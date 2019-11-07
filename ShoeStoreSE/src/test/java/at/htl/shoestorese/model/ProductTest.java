package at.htl.shoestorese.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class ProductTest {

    static EntityManager em;

    @BeforeAll
    private static void init(){
        em = Persistence.createEntityManagerFactory("myPU").createEntityManager();
    }

    @Test
    void test01DatabaseConnection() {
        Product shoe = new Product("Adidas", "Continental 80", 99.99);
        em.getTransaction().begin();
        em.persist(shoe);
        shoe.setName("Continental 80");
        em.getTransaction().commit();
    }

    @Test
    void test02readOneProduct() {
        Product shoe = em.find(Product.class,1L);
        assertThat(shoe.getBrand(),is("Adidas"));
        assertThat(shoe.getName(),is("Continental 80"));
        assertThat(shoe.getPrice(),is(99.99));
    }
}
