package adbistju.system.controllers.admin;

import adbistju.system.dtos.ProductDto;
import adbistju.system.error_handling.InvalidDataException;
import adbistju.system.error_handling.ResourceNotFoundException;
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

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminProductController {
    private final ProductService productService;
    private final AdminMasterService adminMasterService;

    @GetMapping
    public Page<ProductDto> getAllProducts(@RequestParam MultiValueMap<String, String> params,
                                           @RequestParam(name = "p", defaultValue = "1") int page) {
        if (page < 1) {
            page = 1;
        }
        return productService.findAll(ProductSpecifications.build(params), page, 10);
    }

    @GetMapping("/{id}")
    public ProductDto getOneProductById(@PathVariable Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product doesn't exists id: " + id));
        return new ProductDto(product);
    }

    @GetMapping("/newProduct")
    public ProductDto createNewProduct(@RequestParam MultiValueMap<String, String> params) {
        return adminMasterService.createNewProduct(params);
    }

//    @PutMapping
//    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
//        return productService.updateProduct(productDto);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable Long id) {
//        productService.deleteById(id);
//    }
}
