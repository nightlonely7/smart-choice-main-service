package au.com.nab.smartchoice.dto.kafkamessage;

import au.com.nab.smartchoice.utility.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data
public class HttpLogKafkaMessage {

    @JsonProperty("log_id")
    private UUID logId;

    @JsonProperty("request_line")
    private String requestLine;

    @JsonProperty("response_status")
    private Integer responseStatus;

    @JsonProperty("src_ip")
    private String srcIp;

    @JsonProperty("des_ip")
    private String desIp;

    @JsonProperty("request_body")
    private String requestBody;

    @JsonProperty("response_body")
    private String responseBody;

    @JsonProperty("request_header")
    private Map<String, Object> requestHeader;

    @JsonProperty("response_header")
    private Map<String, Object> responseHeader;

    @JsonProperty("requested_at")
    @JsonFormat(pattern = Constant.DATE_TIME_FORMAT)
    private LocalDateTime requestedAt;

    @JsonProperty("responded_at")
    @JsonFormat(pattern = Constant.DATE_TIME_FORMAT)
    private LocalDateTime respondedAt;
}
