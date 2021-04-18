package au.com.nab.smartchoice.dto.httpresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseHttpResponse<DataType> {

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private DataType data;

    @JsonProperty("metadata")
    private String metadata;

    @JsonProperty("error")
    private String error;
}
