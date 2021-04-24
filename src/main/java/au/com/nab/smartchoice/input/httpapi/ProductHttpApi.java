package au.com.nab.smartchoice.input.httpapi;

import au.com.nab.smartchoice.dto.mapper.ProductMapper;
import au.com.nab.smartchoice.dto.other.ProductSearch;
import au.com.nab.smartchoice.dto.response.GetProductPageDataResponse;
import au.com.nab.smartchoice.dto.response.GetProductPageResponse;
import au.com.nab.smartchoice.service.ProductPriceService;
import au.com.nab.smartchoice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static au.com.nab.smartchoice.utility.Constant.NOT_FOUND_RESPONSE_CODE;
import static au.com.nab.smartchoice.utility.Constant.OBTAINED_RESPONSE_CODE;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductHttpApi {

    private final ProductService productService;
    private final ProductPriceService productPriceService;
    private final ProductMapper productMapper;
//    private final KafkaTemplate<String, String> kafkaTemplate;
//    private final StringRedisTemplate stringRedisTemplate;

    @GetMapping
    public ResponseEntity<GetProductPageResponse> getProductPage(ProductSearch productSearch, @PageableDefault Pageable pageable) {
        //kafkaTemplate.send("test-topic", "test-data");
//        stringRedisTemplate.opsForHash().put("test-hash", "test-id", "test-data2");
//        stringRedisTemplate.opsForValue().append("test-key", "test-value");
        log.info(productSearch.toString());

        var productModelPage = productService.getProductPage(productSearch, pageable);

        var getProductPageResponse = new GetProductPageResponse();
        if (productModelPage.getTotalElements() == 0) {
            getProductPageResponse.setCode(NOT_FOUND_RESPONSE_CODE);
            getProductPageResponse.setMessage("Product page not found.");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getProductPageResponse);
        }
        getProductPageResponse.setCode(OBTAINED_RESPONSE_CODE);
        getProductPageResponse.setMessage("Product page obtained.");
        var getProductPageDataResponse = new GetProductPageDataResponse();
        getProductPageDataResponse.setProductPage(productModelPage.map(productMapper::modelToResponse));
        getProductPageResponse.setData(getProductPageDataResponse);

        return ResponseEntity.ok(getProductPageResponse);
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<?> getProductDetail(@PathVariable("product-id") String productId) {
        return ResponseEntity.ok(productMapper.modelToResponse(productService.getProductDetail(productId)));
    }

    @GetMapping("/synchronizable")
    public ResponseEntity<?> getSynchronizableProductId() {
        return ResponseEntity.ok(productService.getSynchronizableProductId());
    }

    @GetMapping("/{product-id}/prices")
    public ResponseEntity<?> getProductPriceList(@PathVariable("product-id") String productId) {
        return ResponseEntity.ok(productPriceService.getProductPrice(productId));
    }
}
