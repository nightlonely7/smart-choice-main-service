package au.com.nab.smartchoice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class ProductDetailResponse {

    @JsonProperty("html")
    private String html;

    @JsonProperty("attributes")
    private Map<String, Object> attributes;
}
