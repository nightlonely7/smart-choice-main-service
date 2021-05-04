package au.com.nab.smartchoice.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "product-price-service")
public class ProductPriceServiceProperty {
    private String serviceId;
}
