package adbistju.system.services;


import adbistju.system.dtos.ProductDto;
import adbistju.system.dtos.oreder.OrderItemDto;
import adbistju.system.models.Cart;
import adbistju.system.models.product.Product;
import adbistju.system.models.user.User;
import adbistju.system.repository.specifications.ProductSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AdminMasterService {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final OrderService orderService;
    private final RolesService rolesService;
    private final BCryptPasswordEncoder passwordEncoder;

    public ProductDto createNewProduct(MultiValueMap<String, String> params) {
        Product product = new Product();
        product.setTitle(params.getFirst("title"));
        product.setPrice(BigDecimal.valueOf(Long.parseLong(params.getFirst("price"))));
        Collection collection = new ArrayList();
        for (int i = 0; i < params.get("category_id").size(); i++) {
            collection.add(categoryService.findById(Long.parseLong(params.get("category_id").get(i))).get());
        }
        product.setCategory(collection);
        return productService.createNewProduct(product);
    }
}
