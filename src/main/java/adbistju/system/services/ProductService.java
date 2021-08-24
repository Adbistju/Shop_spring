package adbistju.system.services;

import adbistju.system.dtos.ProductDto;
import adbistju.system.error_handling.ResourceNotFoundException;
import adbistju.system.models.product.Category;
import adbistju.system.models.product.Product;
import adbistju.system.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

//    public Page<Product> findPage(int page, int pageSize) {
//        return productRepository.findAllBy(PageRequest.of(page, pageSize));
//    }

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        return productRepository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(ProductDto::new);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public ProductDto createNewProduct(Product product) {
        productRepository.save(product);
        return new ProductDto(product);
    }
//
//    @Transactional
//    public ProductDto updateProduct(ProductDto productDto) {
//        Product product = findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Product doesn't exists id: " + productDto.getId() + " (for update)"));
//        product.setPrice(productDto.getPrice());
//        product.setTitle(productDto.getTitle());
////        Collection<Category> category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category doesn't exists product.categoryTitle = " + productDto.getCategoryTitle() + " (Product creation)"));
////        product.setCategory(category);
//        return new ProductDto(product);
//    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}