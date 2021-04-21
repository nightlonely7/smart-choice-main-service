package au.com.nab.smartchoice.dto.httpreception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GetProductPriceHttpReception extends BaseHttpReception<GetProductPriceDataHttpReception> {
}


