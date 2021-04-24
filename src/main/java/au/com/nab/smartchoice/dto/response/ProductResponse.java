package au.com.nab.smartchoice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductResponse {

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("category_id")
    private String categoryId;

    @JsonProperty("img_url")
    private String imgUrl;

    @JsonProperty("detail")
    private ProductDetailResponse detail;
}
