package au.com.nab.smartchoice.feignclient;

import au.com.nab.smartchoice.dto.clientresponse.GetProductPriceListClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "product-price-service", name = "${product-price-service.service-id}")
public interface ProductPriceServiceClient {

    @GetMapping(path = "/product-prices")
    ResponseEntity<GetProductPriceListClientResponse> getProductPrice(@RequestParam("product-id") String productId);
}
