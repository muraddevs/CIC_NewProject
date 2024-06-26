package CIC.NewProject.service;

import CIC.NewProject.entity.Product;
import CIC.NewProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public  List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }


    public Optional<Product> findById(Long Id) {

        return productRepository.findById(Id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
