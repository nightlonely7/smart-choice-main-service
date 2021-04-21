package au.com.nab.smartchoice.dto.model;

import lombok.Data;

@Data
public class ProductPriceModel {
    private String productId;
    private String partner;
    private String price;
    private String basePrice;
    private String promotion;
    private String location;
    private String link;
}
