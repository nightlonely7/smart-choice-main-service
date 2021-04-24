package au.com.nab.smartchoice.service.impl;

import au.com.nab.smartchoice.dto.mapper.ProductPriceMapper;
import au.com.nab.smartchoice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.feignclient.ProductPriceServiceClient;
import au.com.nab.smartchoice.service.ProductPriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService {

    private final ProductPriceServiceClient productPriceServiceClient;

    private final ProductPriceMapper productPriceMapper;

    @Override
    public List<ProductPriceModel> getProductPrice(String productId) {
        var responseEntity = productPriceServiceClient.getProductPrice(productId);
        var getProductPriceHttpReception = responseEntity.getBody();
        var getProductPriceDataClientResponse = getProductPriceHttpReception.getData();
        var productPriceClientResponseList = getProductPriceDataClientResponse.getProductPriceList();
        return productPriceClientResponseList.stream().map(productPriceMapper::clientResponseToModel).collect(Collectors.toList());
    }

}
