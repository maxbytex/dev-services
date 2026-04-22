package es.max.dev_test_back_end.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class SimilarProductsClient {

    private final RestClient restClient;

    public SimilarProductsClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://localhost:3001")
                .build();
    }
    //todo
    public List<Integer> getSimilarProductIds(String productId) {
        return restClient.get()
                .uri("/product/{id}/similarids", productId)
                .retrieve()
                .body(List.class);
    }


}
