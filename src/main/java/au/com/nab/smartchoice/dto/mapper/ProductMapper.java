package au.com.nab.smartchoice.dto.mapper;

import au.com.nab.smartchoice.dto.entity.ProductEntity;
import au.com.nab.smartchoice.dto.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {
    ProductEntity modelToEntity(ProductModel productModel);
    @Mapping(source = "productId", target = "productId")
    ProductModel entityToModel(ProductEntity productEntity);
}
