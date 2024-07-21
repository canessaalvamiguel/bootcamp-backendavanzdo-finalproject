package dev.canessaalvamiguel.serviceproducts.repository;

import dev.canessaalvamiguel.serviceproducts.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  Page<Product> findByCompanyId(Long companyId, Pageable pageable);
}
