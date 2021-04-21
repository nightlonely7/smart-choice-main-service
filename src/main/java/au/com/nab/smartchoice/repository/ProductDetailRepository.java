package au.com.nab.smartchoice.repository;

import au.com.nab.smartchoice.dto.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, UUID> {
    Optional<ProductDetailEntity> findByProductId(String productId);
}
