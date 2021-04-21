package au.com.nab.smartchoice.service;

import au.com.nab.smartchoice.dto.model.ProductModel;
import au.com.nab.smartchoice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.dto.other.ProductSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Page<ProductModel> getProductPage(ProductSearch productSearch, Pageable pageable);
    ProductModel getProductDetail(String productId);
    List<ProductPriceModel> getProductPrice(String productId);
    List<String> getSynchronizableProductId();
}
