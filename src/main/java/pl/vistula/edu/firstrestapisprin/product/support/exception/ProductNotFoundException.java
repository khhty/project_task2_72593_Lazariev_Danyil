package pl.vistula.edu.firstrestapisprin.product.support.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Product with %d not found " + id);
    }
}
