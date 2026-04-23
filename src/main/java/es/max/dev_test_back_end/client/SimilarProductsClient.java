package es.max.dev_test_back_end.client;

import es.max.dev_test_back_end.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class SimilarProductsClient {

    private final RestClient restClient;

    public SimilarProductsClient(@Value("${external.api.base-url}") String baseUrl,
                                 ClientHttpRequestFactory requestFactory) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .requestFactory(requestFactory)
                .build();
    }

    public List<Integer> getSimilarProductIds(String productId) {
        try {
            return restClient.get()
                    .uri("/product/{id}/similarids", productId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {});
        } catch (HttpClientErrorException.NotFound e) {
            throw new ProductNotFoundException(productId);
        }
    }
}
