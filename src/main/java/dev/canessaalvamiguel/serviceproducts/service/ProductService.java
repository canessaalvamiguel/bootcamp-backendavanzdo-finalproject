package dev.canessaalvamiguel.serviceproducts.service;

import dev.canessaalvamiguel.serviceproducts.entities.Product;
import dev.canessaalvamiguel.serviceproducts.exceptions.NotFoundException;
import dev.canessaalvamiguel.serviceproducts.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

  ProductRepository productRepository;

  public Page<Product> getProducts(int page, int size){
    Pageable pageable = PageRequest.of(page, size);
    return productRepository.findAll(pageable);
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

  public Page<Product> getProductsByCompanyId(Long companyId, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return productRepository.findByCompanyId(companyId, pageable);
  }
}
