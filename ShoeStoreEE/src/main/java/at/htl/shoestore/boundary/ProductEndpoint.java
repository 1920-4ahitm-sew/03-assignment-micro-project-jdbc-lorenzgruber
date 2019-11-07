package at.htl.shoestore.boundary;

import at.htl.shoestore.model.Product;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("product")
public class ProductEndpoint {
    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init(){
        System.err.println("VehicleEndpoint created *****");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Product getProduct(@PathParam("id") long id) {
        return em.find(Product.class, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public List<Product> getAll() {
        return em.createNamedQuery("product.findall", Product.class).getResultList();
    }
}
