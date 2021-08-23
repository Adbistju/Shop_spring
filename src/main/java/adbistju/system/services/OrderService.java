package adbistju.system.services;

import adbistju.system.models.Cart;
import adbistju.system.models.order.Order;
import adbistju.system.models.user.User;
import adbistju.system.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;

    public List<Order> findAllByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

    public Order createOrderForCurrentUser(User user, Cart cart) {
        Order order = new Order();
        order.setUser(user);
        cart.recalculate();
        order.setPrice(cart.getSum());
        orderRepository.save(order);
//        System.out.println(cart.getItems().toString());
        for (int i = 0; i < cart.getItems().size(); i++) {
            System.out.println("createItemOrder");
            System.out.println(productService.findById(cart.getItems().get(i).getProductId()).get());
            orderItemService.createOrderItem(order, productService.findById(cart.getItems().get(i).getProductId()).get());
        }
        System.out.println("---------------------------------------------");
        orderRepository.save(order);
        cart.getItems().clear();
        return order;
    }
////        Cart cart = cartService.getCurrentCart(user.getUsername());
////        order.setPrice(cart.getSum());
//        // todo распутать этот кусок
//        order.setItems(new ArrayList<>());
//        for (OrderItemDto o : cart.getItems()) {
//            OrderItem orderItem = new OrderItem();
//            order.getItems().add(orderItem);
//            orderItem.setOrder(order);
//            orderItem.setQuantity(o.getQuantity());
//            orderItem.setPricePerProduct(o.getPricePerProduct());
//            orderItem.setPrice(o.getPrice());
//            orderItem.setProduct(productService.findById(o.getProductId()).get());
//        }
//        order = orderRepository.save(order);
//        cart.clear();
//        cartService.save(user.getUsername(), cart);
//        return order;
}
