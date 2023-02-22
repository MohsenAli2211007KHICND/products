package gul.products;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

    Optional<Product> findByProductName(String productName);

}
