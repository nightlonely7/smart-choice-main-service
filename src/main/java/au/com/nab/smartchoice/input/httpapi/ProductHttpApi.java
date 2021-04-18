package au.com.nab.smartchoice.input.httpapi;

import au.com.nab.smartchoice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductHttpApi {

    private final ProductService productService;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    public ResponseEntity<?> getProductList() {
        //kafkaTemplate.send("test-topic", "test-data");
        stringRedisTemplate.opsForHash().put("test-hash", "test-id", "test-data2");
        stringRedisTemplate.opsForValue().append("test-key", "test-value");
        return null;
    }
}
