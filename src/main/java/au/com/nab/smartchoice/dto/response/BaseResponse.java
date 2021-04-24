package au.com.nab.smartchoice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseResponse<DataType> {

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DataType data;
//
//    @JsonProperty("metadata")
//    private String metadata;
//
//    @JsonProperty("error")
//    private String error;
}
