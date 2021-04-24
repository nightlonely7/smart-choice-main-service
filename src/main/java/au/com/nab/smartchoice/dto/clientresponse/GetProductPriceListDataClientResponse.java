package au.com.nab.smartchoice.dto.clientresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetProductPriceListDataClientResponse {

    @JsonProperty("product_price_list")
    private List<ProductPriceClientResponse> productPriceList;
}
