package es.max.dev_test_back_end.controller;


import es.max.dev_test_back_end.dto.SimilarProductsResponse;
import es.max.dev_test_back_end.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}/similar")
    public SimilarProductsResponse getSimilar(@PathVariable String productId) {
        return productService.getSimilarProducts(productId);
    }
}
