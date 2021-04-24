package au.com.nab.smartchoice.dto.mapper;

import au.com.nab.smartchoice.dto.entity.ProductDetailEntity;
import au.com.nab.smartchoice.dto.model.ProductDetailModel;
import au.com.nab.smartchoice.dto.response.ProductDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductDetailMapper {
    @Mapping(target = "attributes", ignore = true)
    ProductDetailEntity modelToEntity(ProductDetailModel productDetailModel);

    @Mapping(target = "attributes", ignore = true)
    ProductDetailModel entityToModel(ProductDetailEntity productDetailEntity);

    ProductDetailResponse modelToResponse(ProductDetailModel productDetailModel);
}
