package pl.vistula.edu.firstrestapisprin.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.vistula.edu.firstrestapisprin.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}