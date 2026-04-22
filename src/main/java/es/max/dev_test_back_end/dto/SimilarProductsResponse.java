package es.max.dev_test_back_end.dto;

import es.max.dev_test_back_end.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SimilarProductsResponse {

    private List<ProductDto> products;


}
