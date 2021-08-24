package adbistju.system.controllers.admin;

import adbistju.system.dtos.ProductDto;
import adbistju.system.error_handling.InvalidDataException;
import adbistju.system.error_handling.ResourceNotFoundException;
import adbistju.system.models.product.Category;
import adbistju.system.models.product.Product;
import adbistju.system.repository.specifications.ProductSpecifications;
import adbistju.system.services.AdminMasterService;
import adbistju.system.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminProductController {
    private final ProductService productService;
    private final AdminMasterService adminMasterService;

    @GetMapping("/products")
    public Page<ProductDto> getAllProducts(@RequestParam MultiValueMap<String, String> params,
                                           @RequestParam(name = "p", defaultValue = "1") int page) {
        if (page < 1) {
            page = 1;
        }
        return productService.findAll(ProductSpecifications.build(params), page, 10);
    }

    @GetMapping("/products/{id}")
    public ProductDto getOneProductById(@PathVariable Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product doesn't exists id: " + id));
        return new ProductDto(product);
    }
//http://localhost:8080/admin/newProduct?title=%D1%82%D0%B5%D1%81%D1%82&price=9999999&category_id=1&category_id=2
    @GetMapping("/products/newProduct")
    public ProductDto createNewProduct(@RequestParam MultiValueMap<String, String> params) {
        return adminMasterService.createNewProduct(params);
    }

    @PutMapping("/products/update")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return adminMasterService.updateProduct(productDto);
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
