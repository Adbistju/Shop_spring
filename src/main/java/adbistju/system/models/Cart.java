package adbistju.system.models;

import adbistju.system.dtos.ProductDto;
import adbistju.system.dtos.oreder.OrderItemDto;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

@Component
@Data
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {
    //private List<OrderItemDto> items;
    private ArrayList<OrderItemDto> items;
    private BigDecimal sum;

    public Cart() {
        items = new ArrayList<>();
        sum = BigDecimal.ZERO;
    }


    public void addItem(OrderItemDto orderItemDto) {
        for (OrderItemDto i: items) {
            if(i.equals(orderItemDto)){
                i.setQuantity(i.getQuantity()+1);
                return;
            }
        }
        orderItemDto.setQuantity(orderItemDto.getQuantity()+1);
        items.add(orderItemDto);
        recalculate();
    }

    public void decrementProduct(Long id) {
        Iterator<OrderItemDto> iter = items.iterator();
        while (iter.hasNext()) {
            OrderItemDto o = iter.next();
            if (o.getProductId().equals(id)) {
                o.changeQuantity(-1);
                if (o.getQuantity() <= 0) {
                    iter.remove();
                }
                recalculate();
                return;
            }
        }
    }

    public void deleteItem(OrderItemDto orderItemDto) {
        items.remove(orderItemDto);
        recalculate();
    }

    public void deleteItem(Long id) {
        items.remove(id);
        recalculate();
    }

    public void recalculate(){
        sum = BigDecimal.ZERO;
        for (OrderItemDto i: items) {
            sum = sum.add(i.getPrice());
        }
    }


}
