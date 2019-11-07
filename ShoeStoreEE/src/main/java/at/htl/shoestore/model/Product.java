package at.htl.shoestore.model;

import javax.persistence.*;

@Entity
@NamedQueries(
        @NamedQuery(
                name = "product.findall",
                query = "select v from Product v"
        )
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String brand;
    String name;
    double price;

    public Product() { }

    public Product(String brand, String name, double price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ": " + brand + " " + name + " -," + price;
    }
}
