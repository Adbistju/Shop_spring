package adbistju.system.services;

import adbistju.system.dtos.ProductDto;
import adbistju.system.dtos.oreder.OrderDto;
import adbistju.system.models.Cart;
import adbistju.system.models.order.Order;
import adbistju.system.models.product.Product;
import adbistju.system.models.user.User;
import adbistju.system.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
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

    public Page<OrderDto> findAll(Specification<Order> spec, int page, int pageSize) {
        return orderRepository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(OrderDto::new);
    }

    public Order createOrderForCurrentUser(User user, Cart cart) {
        Order order = new Order();
        order.setUser(user);
        cart.recalculate();
        order.setPrice(cart.getSum());
        orderRepository.save(order);
//        System.out.println(cart.getItems().toString());
        for (int i = 0; i < cart.getItems().size(); i++) {
            System.out.println(productService.findById(cart.getItems().get(i).getProductId()).get());
            orderItemService.createOrderItem(order, productService.findById(cart.getItems().get(i).getProductId()).get(),cart.getItems().get(i).getQuantity());
        }
        orderRepository.save(order);
        cart.getItems().clear();
        return order;
    }
}
