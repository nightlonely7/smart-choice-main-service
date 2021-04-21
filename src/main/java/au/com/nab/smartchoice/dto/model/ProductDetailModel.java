package au.com.nab.smartchoice.dto.model;

import lombok.Data;

import java.util.Map;

@Data
public class ProductDetailModel {
    private String html;
    private Map<String, Object> attributes;
}
