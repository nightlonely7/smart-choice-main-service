package au.com.nab.smartchoice.service;

import au.com.nab.smartchoice.dto.model.ProductPriceModel;

import java.util.List;

public interface ProductPriceService {
    List<ProductPriceModel> getProductPrice(String productId);
}
