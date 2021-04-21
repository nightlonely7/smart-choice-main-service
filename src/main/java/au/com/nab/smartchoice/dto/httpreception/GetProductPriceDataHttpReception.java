package au.com.nab.smartchoice.dto.httpreception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetProductPriceDataHttpReception {

    @JsonProperty("product_price_list")
    private List<ProductPriceHttpReception> productPriceList;
}
