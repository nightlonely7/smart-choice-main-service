package au.com.nab.smartchoice.dto.mapper;

import au.com.nab.smartchoice.dto.entity.ProductEntity;
import au.com.nab.smartchoice.dto.model.ProductModel;
import au.com.nab.smartchoice.dto.response.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(uses = ProductDetailMapper.class)
public interface ProductMapper {

    ProductEntity modelToEntity(ProductModel productModel);

    ProductModel entityToModel(ProductEntity productEntity);

    ProductResponse modelToResponse(ProductModel productModel);
}
