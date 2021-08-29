package adbistju.system.controllers.user;

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
    public void addProductToCart(Principal principal, @PathVariable Long id) {
        masterService.addToCart(principal,id,cart);
    }

    @GetMapping("/subtract/{id}")
    public void subtractProductToCart(Principal principal, @PathVariable Long id) {
        masterService.decrementProduct(principal,id,cart);
    }

    @GetMapping("/delete/{id}")
    public void deleteProductToCart(Principal principal, @PathVariable Long id) {
        masterService.deleteProductId(principal,id,cart);
    }

    @GetMapping("/get")
    public ArrayList<OrderItemDto> getCart(Principal principal) {
        return cart.getItems();
    }

    @GetMapping("/clear")
    public void clearCart(Principal principal) {
        cart.getItems().clear();
    }

    @GetMapping("/create")
    public void createOrder(Principal principal) {
        masterService.createOrder(principal,cart);
    }
}
