package au.com.nab.smartchoice.input.httpapi;

import au.com.nab.smartchoice.dto.other.ProductSearch;
import au.com.nab.smartchoice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductHttpApi {

    private final ProductService productService;
//    private final KafkaTemplate<String, String> kafkaTemplate;
//    private final StringRedisTemplate stringRedisTemplate;

    @GetMapping
    public ResponseEntity<?> getProductPage(ProductSearch productSearch,@PageableDefault Pageable pageable) {
        //kafkaTemplate.send("test-topic", "test-data");
//        stringRedisTemplate.opsForHash().put("test-hash", "test-id", "test-data2");
//        stringRedisTemplate.opsForValue().append("test-key", "test-value");
        log.info(productSearch.toString());
        return ResponseEntity.ok(productService.getProductPage(productSearch, pageable));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<?> getProductDetail(@PathVariable("product-id") String productId) {
        return ResponseEntity.ok(productService.getProductDetail(productId));
    }

    @GetMapping("/{product-id}/prices")
    public ResponseEntity<?> getProductPriceList(@PathVariable("product-id") String productId) {
        return null;
    }

    @GetMapping("/synchronizable")
    public ResponseEntity<?> getSynchronizableProductId() {
        return ResponseEntity.ok(productService.getSynchronizableProductId());
    }
}
