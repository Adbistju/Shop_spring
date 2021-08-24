package adbistju.system.controllers.admin;

import adbistju.system.dtos.ProductDto;
import adbistju.system.error_handling.ResourceNotFoundException;
import adbistju.system.models.product.Category;
import adbistju.system.models.product.Product;
import adbistju.system.repository.specifications.ProductSpecifications;
import adbistju.system.services.AdminMasterService;
import adbistju.system.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminCategoryController {
    private final ProductService productService;
    private final AdminMasterService adminMasterService;


    @GetMapping("/category")
    public ArrayList<Category> getAllProducts(@RequestParam MultiValueMap<String, String> params) {
        return adminMasterService.getAllCategory(params);
    }

    @PutMapping("/category/update")
    public Category updateCategory(@RequestBody Category category) {
        return adminMasterService.updateCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        adminMasterService.deleteCategory(id);
    }
}
