package pl.vistula.edu.firstrestapisprin.product.service;

import pl.vistula.edu.firstrestapisprin.product.api.request.UpdateProductRequest;
import org.springframework.stereotype.Service;
import pl.vistula.edu.firstrestapisprin.product.api.request.ProductRequest;
import pl.vistula.edu.firstrestapisprin.product.api.response.ProductResponse;
import pl.vistula.edu.firstrestapisprin.product.domain.Product;
import pl.vistula.edu.firstrestapisprin.product.repository.ProductRepository;
import pl.vistula.edu.firstrestapisprin.product.support.ProductMapper;
import pl.vistula.edu.firstrestapisprin.product.support.ProductExceptionSupplier;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository,
                          ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse create(ProductRequest productRequest) {
        Product product = productRepository.save(productMapper.toProduct(productRequest));

        return productMapper.toProductResponse(product);
    }
    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }
    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.save(productMapper.toProduct(product, updateProductRequest));
        return productMapper.toProductResponse(product);

}
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());

    }
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.deleteById(product.getId());
    }
}
