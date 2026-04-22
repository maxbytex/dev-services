package es.max.dev_test_back_end.client;

import es.max.dev_test_back_end.dto.ProductDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ProductClient {

    private final RestClient restClient;

    public ProductClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://localhost:3001")
                .build();
    }

    public ProductDto getProductById(String productId) {
        return restClient.get()
                .uri("/product/{id}", productId)
                .retrieve()
                .body(ProductDto.class);
    }
}
