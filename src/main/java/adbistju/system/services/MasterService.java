package adbistju.system.services;


import adbistju.system.dtos.oreder.OrderItemDto;
import adbistju.system.facade.ProductFacade;
import adbistju.system.models.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class MasterService {
    private final UserService userService;
    private final ProductService productService;
    //private final CategoryService categoryService;
    private final OrderService orderService;
    //private final OrderItemService orderItemService;
    //private final OrderItemDto orderItemDto;

    @Autowired
    private ProductFacade productFacade;


    public void addToCart(Principal principal,Long idProduct, Cart cart){
        OrderItemDto orderItemDto = new OrderItemDto(productService.findById(idProduct).get());
        cart.addItem(orderItemDto);
    }

    public void decrementProduct(Long id, Cart cart){
        cart.decrementProduct(id);
    }

    public void deleteProductId(Long id, Cart cart){
        cart.deleteItem(id);
    }

    public void createOrder(Principal principal, Cart cart){
//        principal.getName();
        orderService.createOrderForCurrentUser(userService.findByUsername(principal.getName()).get(), cart);
        System.out.println("createOrder");
    }
}
