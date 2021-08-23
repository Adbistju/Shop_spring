package adbistju.system.services;

import adbistju.system.models.order.Order;
import adbistju.system.models.order.OrderItem;
import adbistju.system.models.product.Product;
import adbistju.system.models.user.User;
import adbistju.system.repository.OrderItemRepository;
import adbistju.system.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    //private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public List<OrderItem> findAllByOrder(Order order) {
        return orderItemRepository.findAllByOrder(order);
    }

    public void  createOrderItem(Order order, Product product,int quantity){
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setPrice(product.getPrice());
        orderItem.setPricePerProduct(product.getPrice());
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItemRepository.save(orderItem);
    }
}
