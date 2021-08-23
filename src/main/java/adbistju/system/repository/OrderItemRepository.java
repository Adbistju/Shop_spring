package adbistju.system.repository;

import adbistju.system.models.order.Order;
import adbistju.system.models.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findAll();
    List<OrderItem> findAllByOrder(Order order);


}