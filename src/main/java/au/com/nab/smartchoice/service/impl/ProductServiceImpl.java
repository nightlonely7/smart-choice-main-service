package au.com.nab.smartchoice.service.impl;

import au.com.nab.smartchoice.dto.entity.ProductDetailEntity;
import au.com.nab.smartchoice.dto.httpreception.GetProductPriceDataHttpReception;
import au.com.nab.smartchoice.dto.httpreception.GetProductPriceHttpReception;
import au.com.nab.smartchoice.dto.httpreception.ProductPriceHttpReception;
import au.com.nab.smartchoice.dto.mapper.ProductDetailMapper;
import au.com.nab.smartchoice.dto.mapper.ProductMapper;
import au.com.nab.smartchoice.dto.mapper.ProductPriceMapper;
import au.com.nab.smartchoice.dto.model.ProductDetailModel;
import au.com.nab.smartchoice.dto.model.ProductModel;
import au.com.nab.smartchoice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.dto.other.ProductSearch;
import au.com.nab.smartchoice.feignclient.MsProductPriceClient;
import au.com.nab.smartchoice.repository.ProductDetailRepository;
import au.com.nab.smartchoice.repository.ProductRepository;
import au.com.nab.smartchoice.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static au.com.nab.smartchoice.utility.Constant.notFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;
    private final ProductMapper productMapper;
    private final ProductDetailMapper productDetailMapper;
    private final ProductPriceMapper productPriceMapper;
    private final ObjectMapper objectMapper;
    private final MsProductPriceClient msProductPriceClient;

    @Override
    public Page<ProductModel> getProductPage(ProductSearch productSearch, Pageable pageable) {
        return productRepository.findAllByProductNameAndCategoryId(
                productSearch.getProductName(),
                productSearch.getCategoryId(),
                pageable).map(productMapper::entityToModel);
    }

    @Override
    public ProductModel getProductDetail(String productId) {
        ProductModel productModel = productMapper.entityToModel(productRepository.findByProductId(productId)
                .orElseThrow(notFoundException("productId", productId)));
        ProductDetailEntity productDetailEntity = productDetailRepository.findByProductId(productId)
                .orElseThrow(notFoundException("productId", productId));
        ProductDetailModel productDetailModel = productDetailMapper.entityToModel(productDetailEntity);
        try {
            productDetailModel.setAttributes(objectMapper.readValue(productDetailEntity.getAttributes(), LinkedHashMap.class));
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
        productModel.setDetail(productDetailModel);
        return productModel;
    }

    @Override
    public List<ProductPriceModel> getProductPrice(String productId) {
        ResponseEntity<GetProductPriceHttpReception> responseEntity = msProductPriceClient.getProductPrice(productId);
        GetProductPriceHttpReception getProductPriceHttpReception = responseEntity.getBody();
        GetProductPriceDataHttpReception getProductPriceDataHttpReception = getProductPriceHttpReception.getData();
        List<ProductPriceHttpReception> productPriceHttpReceptionList = getProductPriceDataHttpReception.getProductPriceList();
        return productPriceHttpReceptionList.stream().map(productPriceMapper::receptionToModel).collect(Collectors.toList());
    }
}
