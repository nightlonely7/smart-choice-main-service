package au.com.nab.smartchoice.dto.httpresponse;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GetProductListHttpResponse extends BaseHttpResponse<GetProductListDataHttpResponse> {
}
