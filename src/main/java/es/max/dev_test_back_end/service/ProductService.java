package es.max.dev_test_back_end.service;

import es.max.dev_test_back_end.client.ProductClient;
import es.max.dev_test_back_end.client.SimilarProductsClient;
import es.max.dev_test_back_end.dto.ProductDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class ProductService {

    private final SimilarProductsClient similarProductsClient;
    private final ProductClient productClient;
    private final Executor executor;

    public ProductService(SimilarProductsClient similarProductsClient,
                          ProductClient productClient,
                          @Qualifier("productFetchExecutor") Executor executor) {
        this.similarProductsClient = similarProductsClient;
        this.productClient = productClient;
        this.executor = executor;
    }

    public List<ProductDto> getSimilarProducts(String productId) {
        List<Integer> similarIds = similarProductsClient.getSimilarProductIds(productId);

        List<CompletableFuture<Optional<ProductDto>>> futures = similarIds.stream()
                .map(id -> CompletableFuture.supplyAsync(
                        () -> productClient.getProductById(String.valueOf(id)),
                        executor
                ))
                .toList();

        return futures.stream()
                .map(CompletableFuture::join)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
