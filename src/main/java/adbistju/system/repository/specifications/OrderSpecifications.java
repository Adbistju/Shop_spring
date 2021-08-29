package adbistju.system.repository.specifications;

import adbistju.system.models.order.Order;
import adbistju.system.models.product.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;

public class OrderSpecifications {
    private static Specification<Order> priceGreaterOrEqualsThan(int minPrice) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    private static Specification<Order> priceLesserOrEqualsThan(int maxPrice) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    private static Specification<Order> titleLike(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

    private static Specification<Order> idProduct(int idProduct) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), idProduct);
    }
//    private static Specification<Product> category(Category category) {
//        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("Category"), category);
//    }



    public static Specification<Order> build(MultiValueMap<String, String> params) {
        int click = 0;
        Specification<Order> spec = Specification.where(null);
        if (params.containsKey("min_price") && !params.getFirst("min_price").isBlank()) {
            spec = spec.and(OrderSpecifications.priceGreaterOrEqualsThan(Integer.parseInt(params.getFirst("min_price"))));
            click++;
        }
        if (params.containsKey("max_price") && !params.getFirst("max_price").isBlank()) {
            spec = spec.and(OrderSpecifications.priceLesserOrEqualsThan(Integer.parseInt(params.getFirst("max_price"))));
            click++;
        }
        if (params.containsKey("title") && !params.getFirst("title").isBlank()) {
            spec = spec.and(OrderSpecifications.titleLike(params.getFirst("title")));
            click++;
        }
        if (params.containsKey("user_id") && !params.getFirst("user_id").isBlank()) {
            String[] valueFilter = new String[params.get("user_id").size()-click];
            for (int i = click; i < valueFilter.length; i++) {
                spec = spec.or(OrderSpecifications.idProduct(Integer.parseInt(params.get("user_id").get(i-click))));
            }
        }
//        if (params.containsKey("category") && !params.getFirst("category").isBlank()) {
//            spec = spec.and(ProductSpecifications.category(params.getFirst("category")));
//        }

        click = 0;
        return spec;
    }
}
