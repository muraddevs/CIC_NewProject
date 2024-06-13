package CIC.NewProject.entity;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CustomerProduct> customerProducts = new HashSet<>();

    // Constructors, getters, setters, etc.
    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<CustomerProduct> getCustomerProducts() {
        return customerProducts;
    }

    public void setCustomerProducts(Set<CustomerProduct> customerProducts) {
        this.customerProducts = customerProducts;
    }
}
