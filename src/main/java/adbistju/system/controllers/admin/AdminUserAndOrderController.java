package adbistju.system.controllers.admin;

import adbistju.system.dtos.UserDto;
import adbistju.system.dtos.oreder.OrderDto;
import adbistju.system.models.product.Category;
import adbistju.system.repository.specifications.OrderSpecifications;
import adbistju.system.repository.specifications.UserSpecifications;
import adbistju.system.services.AdminMasterService;
import adbistju.system.services.OrderService;
import adbistju.system.services.ProductService;
import adbistju.system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminUserAndOrderController {
    private final OrderService orderService;
    private final UserService userService;

    
    @GetMapping("/order")
    public Page<OrderDto> getAllProducts(@RequestParam MultiValueMap<String, String> params,
                                         @RequestParam(name = "p", defaultValue = "1") int page) {
        return orderService.findAll(OrderSpecifications.build(params),page, 10);
    }

    @GetMapping("/user")
    public Page<UserDto> getAllUser(@RequestParam MultiValueMap<String, String> params,
                                    @RequestParam(name = "p", defaultValue = "1") int page) {
        return userService.findAll(UserSpecifications.build(params),page, 10);
    }
}
