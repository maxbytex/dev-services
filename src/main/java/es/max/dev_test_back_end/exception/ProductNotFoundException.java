package es.max.dev_test_back_end.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String productId) {
        super("Product not found:  " + productId);
    }
}
