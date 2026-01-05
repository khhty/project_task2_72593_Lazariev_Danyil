package pl.vistula.edu.firstrestapisprin.product.support;

import org.springframework.stereotype.Component;
import pl.vistula.edu.firstrestapisprin.product.api.request.ProductRequest;
import pl.vistula.edu.firstrestapisprin.product.api.request.UpdateProductRequest;
import pl.vistula.edu.firstrestapisprin.product.api.response.ProductResponse;
import pl.vistula.edu.firstrestapisprin.product.domain.Product;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest) {
        return new Product(productRequest.getName());
    }

    public Product toProduct(Product product, UpdateProductRequest updateProductRequest) {
        product.setName(updateProductRequest.getName());
        return product;
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }
}
