//package adbistju.system.controllers;
//
//
//import adbistju.system.error_handling.ResourceNotFoundException;
//import adbistju.system.models.product.Category;
//import adbistju.system.repository.specifications.CategorySpecifications;
//import adbistju.system.services.CategoryService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/categories")
//public class CategoryController {
//    private final CategoryService categoryService;
//
//    @GetMapping
//    public List<Category> getAllCategory(@RequestParam MultiValueMap<String, String> params){
//        return categoryService.findAll(CategorySpecifications.build(params)).get();
//        /*CategorySpecifications.build(params)).orElseThrow(() -> new ResourceNotFoundException("Category doesn't exists: " + id)*/
//    }
//
//    @GetMapping("/{id}")
//    public Category getOneCategoryById(@PathVariable Long id) {
//        return categoryService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category doesn't exists: " + id));
//    }
//
//}
