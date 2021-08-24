package adbistju.system.controllers.user;

import adbistju.system.dtos.ProductDto;
import adbistju.system.error_handling.InvalidDataException;
import adbistju.system.error_handling.ResourceNotFoundException;
import adbistju.system.models.product.Category;
import adbistju.system.models.product.Product;
import adbistju.system.repository.specifications.ProductSpecifications;
import adbistju.system.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

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
//        ArrayList<Category> list = new ArrayList(product.getCategories().stream().collect(Collectors.toList()));
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        return new ProductDto(product);
    }

//    @PostMapping
//    public ProductDto createNewProduct(@RequestBody @Validated ProductDto productDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new InvalidDataException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
//        }
//        return productService.createNewProduct(productDto);
//    }
//
//    @PutMapping
//    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
//        return productService.updateProduct(productDto);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable Long id) {
//        productService.deleteById(id);
//    }

//    @GetMapping("/test")
//    public ArrayList<Product> getTest() {
//        return  productService.test();
//    }
}
