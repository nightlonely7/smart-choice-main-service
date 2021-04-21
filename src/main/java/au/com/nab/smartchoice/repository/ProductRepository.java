package au.com.nab.smartchoice.repository;

import au.com.nab.smartchoice.dto.entity.ProductEntity;
import au.com.nab.smartchoice.dto.projection.ProductIdProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    @Query("select product from ProductEntity product where " +
            "(:productName is null or product.productName = :productName) and " +
            "(:categoryId is null or product.categoryId = :categoryId)")
    Page<ProductEntity> findAllByProductNameAndCategoryId(@Param("productName") String productName, @Param("categoryId") String categoryId, Pageable pageable);

    Optional<ProductEntity> findByProductId(String productId);

    List<ProductIdProjection> findAllBySynchronizableTrue();
}
