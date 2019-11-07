package at.htl.shoestore.servlet;

import at.htl.shoestore.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("shoestoreservlet")
public class ShoestoreServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TypedQuery<Product> query = em.createNamedQuery("product.findall",Product.class);
        List<Product> products = query.getResultList();
        resp.getWriter().printf("" + products);
    }
}
