package pl.vistula.edu.firstrestapisprin.product.support;

import pl.vistula.edu.firstrestapisprin.product.support.exception.ProductNotFoundException;
import java.util.function.Supplier;

public class ProductExceptionSupplier {
    public static Supplier<ProductNotFoundException> productNotFound(Long id){
        return () -> new ProductNotFoundException(id);
    }
}
