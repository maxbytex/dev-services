package es.max.dev_test_back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProductDto {

    private String id;
    private String name;
    private BigDecimal price;
    private Boolean availability;
}
