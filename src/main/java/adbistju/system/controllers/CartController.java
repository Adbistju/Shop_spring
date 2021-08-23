package adbistju.system.controllers;

import adbistju.system.dtos.oreder.OrderItemDto;
import adbistju.system.models.Cart;
import adbistju.system.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private MasterService masterService;
    private Cart cart;

    @Autowired
    public CartController(Cart cart) {
        this.cart = cart;
    }

//    @GetMapping("/add")
//    public void addToCart(Principal principal, @RequestParam(name = "prodId") Long id/*, @RequestParam String cartName*/) {
//        masterService.addToCart(principal,id,cart);
//    }
    @GetMapping("/add/{id}")
    public void addToCart(Principal principal, @PathVariable Long id/*, @RequestParam String cartName*/) {
        masterService.addToCart(principal,id,cart);
    }

    @GetMapping("/get")
    public ArrayList<OrderItemDto> getCart(Principal principal) {
        return cart.getItems();
    }

    @GetMapping("/create")
    public void createOrder(Principal principal) {
        masterService.createOrder(principal,cart);
    }
}
