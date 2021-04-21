package au.com.nab.smartchoice.feignclient;

import au.com.nab.smartchoice.dto.httpreception.GetProductPriceHttpReception;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "ms-product-price", name = "ms-product-price")
public interface MsProductPriceClient {
    @GetMapping(path = "/product-prices")
    ResponseEntity<GetProductPriceHttpReception> getProductPrice(@RequestParam("product-id") String productId);
}
