package es.max.dev_test_back_end.service;


import es.max.dev_test_back_end.client.ProductClient;
import es.max.dev_test_back_end.client.SimilarProductsClient;
import es.max.dev_test_back_end.dto.ProductDto;
import es.max.dev_test_back_end.dto.SimilarProductsResponse;
import es.max.dev_test_back_end.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    private final SimilarProductsClient similarProductsClient;
    private final ProductClient productClient;

    public ProductService(SimilarProductsClient similarProductsClient,
                          ProductClient productClient) {
        this.similarProductsClient = similarProductsClient;
        this.productClient = productClient;
    }

    public SimilarProductsResponse getSimilarProducts(String productId) {

        List<Integer> similarIds = similarProductsClient.getSimilarProductIds(productId);

        List<ProductDto> products = similarIds.stream()
                .map(String::valueOf)
                .map(productClient::getProductById)
                .toList();

        return new SimilarProductsResponse(products);
    }

}
