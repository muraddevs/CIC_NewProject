package CIC.NewProject.controller;


import CIC.NewProject.entity.Customer;
import CIC.NewProject.entity.CustomerProduct;
import CIC.NewProject.entity.Product;
import CIC.NewProject.service.CustomerService;
import CIC.NewProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            Customer updatedCustomer = customer.get();
            updatedCustomer.setName(customerDetails.getName());
            updatedCustomer.setEmail(customerDetails.getEmail());
            return ResponseEntity.ok(customerService.save(updatedCustomer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{customerId}/products/{productId}")
    public ResponseEntity<CustomerProduct> addProductToCustomer(@PathVariable Long customerId, @PathVariable Long productId) {
        Optional<Customer> customer = customerService.findById(customerId);
        Optional<Product> product = productService.findById(productId);

        if (customer.isPresent() && product.isPresent()) {
            CustomerProduct customerProduct = customerService.addProductToCustomer(customer.get(), product.get());
            return ResponseEntity.ok(customerProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
