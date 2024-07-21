package dev.canessaalvamiguel.serviceproducts.service;

import dev.canessaalvamiguel.serviceproducts.entities.Product;
import dev.canessaalvamiguel.serviceproducts.exceptions.NotFoundException;
import dev.canessaalvamiguel.serviceproducts.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

  ProductRepository productRepository;

  //TODO: Implement pagination
  public List<Product> getProducts(){
    return productRepository.findAll();
  }

  public Product getProductById(Long product){
    return productRepository.findById(product)
        .orElseThrow(
            () -> new NotFoundException("Product with id " + product + " not found.")
        );
  }

  public Product createProduct(Product product){
    return productRepository.save(product);
  }

  public List<Product> getProductsByCompanyId(Long companyId) {
    return productRepository.findByCompanyId(companyId);
  }
}
