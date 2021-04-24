package au.com.nab.smartchoice.dto.mapper;

import au.com.nab.smartchoice.dto.clientresponse.ProductPriceClientResponse;
import au.com.nab.smartchoice.dto.model.ProductPriceModel;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPriceMapper {
    ProductPriceModel clientResponseToModel(ProductPriceClientResponse productPriceClientResponse);
}
