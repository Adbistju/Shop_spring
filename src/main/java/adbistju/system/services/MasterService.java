package adbistju.system.services;


import adbistju.system.dtos.oreder.OrderItemDto;
import adbistju.system.models.Cart;
import adbistju.system.models.user.User;
import adbistju.system.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class MasterService {
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;
    private final RolesService rolesService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void addToCart(Principal principal,Long idProduct, Cart cart){
        OrderItemDto orderItemDto = new OrderItemDto(productService.findById(idProduct).get());
        cart.addItem(orderItemDto);
    }

    public void decrementProduct(Principal principal, Long id, Cart cart){
        cart.decrementProduct(id);
    }

    public void deleteProductId(Principal principal,Long id, Cart cart){
        cart.deleteItem(id);
    }

    public void createOrder(Principal principal, Cart cart){
        orderService.createOrderForCurrentUser(userService.findByUsername(principal.getName()).get(), cart);
    }

    public User createUser(MultiValueMap<String, String> params) {
        User user = new User();
//        System.out.println(params.getFirst("email"));
//        System.out.println(params.getFirst("username"));
//        System.out.println(params.getFirst("password"));
//        try {
//            System.out.println(passwordEncoder.encode(params.getFirst("password")));
//        } catch (Exception e){
//            System.out.println("ошибка декотера");
//        }
        user.setEmail(params.getFirst("email"));
        user.setUsername(params.getFirst("username"));
        user.setPassword(passwordEncoder.encode(params.getFirst("password")));
        rolesService.findById(1L);
        Collection collection = new ArrayList();
        collection.add(rolesService.findById(1L).get());
        user.setRoles(collection);
        return userService.createUser(user);
    }
}
