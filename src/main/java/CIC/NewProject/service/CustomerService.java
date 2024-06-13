package CIC.NewProject.service;



import CIC.NewProject.entity.CustomerProduct;
import CIC.NewProject.entity.Customer;
import CIC.NewProject.entity.Product;
import CIC.NewProject.repository.CustomerProductRepository;
import CIC.NewProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerProductRepository customerProductRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerProduct addProductToCustomer(Customer customer, Product product) {
        CustomerProduct customerProduct = new CustomerProduct(customer, product);
        return customerProductRepository.save(customerProduct);
    }
}
