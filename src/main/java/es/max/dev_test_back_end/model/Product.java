package es.max.dev_test_back_end.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class Product {

   Integer id;

    String name;
    BigDecimal price;
    Boolean availability;


}
