package au.com.nab.smartchoice.dto.model;

import lombok.Data;

@Data
public class ProductModel {
    private String productId;
    private String productName;
    private String categoryId;
    private String imgUrl;
    private ProductDetailModel detail;
}
