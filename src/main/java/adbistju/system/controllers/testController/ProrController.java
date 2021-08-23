package adbistju.system.controllers.testController;
//
//
//import adbistju.system.dtos.ProductDto;
//import adbistju.system.error_handling.ResourceNotFoundException;
//import adbistju.system.models.product.Category;
//import adbistju.system.models.product.Product;
//import adbistju.system.repository.specifications.CategorySpecifications;
//import adbistju.system.services.CategoryService;
//import adbistju.system.services.ProductService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/pro")
//public class ProrController {
//    private final ProductService productService;
//
//    @GetMapping("/{id}")
//    public ProductDto getOneProductById(@PathVariable Long id) {
//        System.out.println("tututu");
//        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product doesn't exists id: " + id));
//        ProductDto productDto = new ProductDto(product);
//
//        ArrayList<Category> list = new ArrayList(productDto.getCategoryTitle().stream().collect(Collectors.toList()));
//        for (int i = 0; i < productDto.getCategoryTitle().size(); i++) {
//            System.out.println(list.get(i).getTitle());
//        }
//
//        return productDto;
//    }
//
//}