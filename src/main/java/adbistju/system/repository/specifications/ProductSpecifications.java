package adbistju.system.repository.specifications;

import adbistju.system.models.product.Category;
import adbistju.system.models.product.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;

import javax.persistence.criteria.Selection;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductSpecifications {
    private static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    private static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    private static Specification<Product> titleLike(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

    private static Specification<Product> idProduct(int idProduct) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), idProduct);
    }
//    private static Specification<Product> category(Category category) {
//        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("Category"), category);
//    }



    public static Specification<Product> build(MultiValueMap<String, String> params) {
        int click = 0;
        Specification<Product> spec = Specification.where(null);
        if (params.containsKey("min_price") && !params.getFirst("min_price").isBlank()) {
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(Integer.parseInt(params.getFirst("min_price"))));
            click++;
        }
        if (params.containsKey("max_price") && !params.getFirst("max_price").isBlank()) {
            spec = spec.and(ProductSpecifications.priceLesserOrEqualsThan(Integer.parseInt(params.getFirst("max_price"))));
            click++;
        }
        if (params.containsKey("title") && !params.getFirst("title").isBlank()) {
            spec = spec.and(ProductSpecifications.titleLike(params.getFirst("title")));
            click++;
        }
        if (params.containsKey("product_id") && !params.getFirst("product_id").isBlank()) {
            String[] valueFilter = new String[params.get("product_id").size()-click];
            for (int i = click; i < valueFilter.length; i++) {
                spec = spec.or(ProductSpecifications.idProduct(Integer.parseInt(params.get("product_id").get(i-click))));
            }
        }
//        if (params.containsKey("category") && !params.getFirst("category").isBlank()) {
//            spec = spec.and(ProductSpecifications.category(params.getFirst("category")));
//        }

        click = 0;
        return spec;
    }
}
