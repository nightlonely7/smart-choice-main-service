package au.com.nab.smartchoice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class GetProductPageDataResponse {

    @JsonProperty("product_page")
    private Page<ProductResponse> productPage;
}
