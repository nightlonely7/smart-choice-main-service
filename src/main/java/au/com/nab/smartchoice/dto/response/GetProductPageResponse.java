package au.com.nab.smartchoice.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GetProductPageResponse extends BaseResponse<GetProductPageDataResponse> {
}
