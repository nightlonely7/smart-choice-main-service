package au.com.nab.smartchoice.dto.clientresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductPriceClientResponse {

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("partner")
    private String partner;

    @JsonProperty("price")
    private String price;

    @JsonProperty("base_price")
    private String basePrice;

    @JsonProperty("promotion")
    private String promotion;

    @JsonProperty("location")
    private String location;

    @JsonProperty("link")
    private String link;
}
