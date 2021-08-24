package adbistju.system.repository.order;

import adbistju.system.models.order.Order;
import adbistju.system.models.product.Product;
import adbistju.system.models.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    List<Order> findAllByUser(User user);

    Page<Product> findAllBy(Pageable pageable);
}