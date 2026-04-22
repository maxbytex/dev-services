package es.max.dev_test_back_end.mapper;

import es.max.dev_test_back_end.dto.ProductDto;
import es.max.dev_test_back_end.model.Product;

public class ProductMapper {
    public static ProductDto toDto(Product product) {
        if (product == null) return null;

        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getAvailability()
        );
    }

    public static Product toModel(ProductDto dto) {
        if (dto == null) return null;

        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getPrice(),
                dto.getAvailability()
        );
    }
}
