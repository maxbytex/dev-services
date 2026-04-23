package es.max.dev_test_back_end.client;

import es.max.dev_test_back_end.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

@Component
public class ProductClient {

    private static final Logger log = LoggerFactory.getLogger(ProductClient.class);

    private final RestClient restClient;

    public ProductClient(@Value("${external.api.base-url}") String baseUrl,
                         ClientHttpRequestFactory requestFactory) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .requestFactory(requestFactory)
                .build();
    }

    public Optional<ProductDto> getProductById(String productId) {
        try {
            ProductDto product = restClient.get()
                    .uri("/product/{id}", productId)
                    .retrieve()
                    .body(ProductDto.class);
            return Optional.ofNullable(product);
        } catch (RestClientException e) {
            log.warn("Failed to fetch product {}: {}", productId, e.getMessage());
            return Optional.empty();
        }
    }
}
