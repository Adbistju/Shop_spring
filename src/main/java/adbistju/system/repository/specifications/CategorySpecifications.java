package adbistju.system.repository.specifications;

import adbistju.system.models.product.Category;
import adbistju.system.models.product.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;

public class CategorySpecifications {
    private static Specification<Category> titleLike(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }
//    private static Specification<Product> category(Category category) {
//        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("Category"), category);
//    }
    public static Specification<Category> build(MultiValueMap<String, String> params) {
        int click = 0;
        Specification<Category> spec = Specification.where(null);
        if (params.containsKey("category_title") && !params.getFirst("category_title").isBlank()) {
            spec = spec.and(CategorySpecifications.titleLike(params.getFirst("category_title")));
            click++;
        }
//        if (params.containsKey("category") && !params.getFirst("category").isBlank()) {
//            spec = spec.and(ProductSpecifications.titleLike(params.getFirst("category")));
//            String[] valueFilter = new String[params.get("product_id").size()-click];
//            for (int i = click; i < valueFilter.length; i++) {
//                spec = spec.or(ProductSpecifications.idProduct(Integer.parseInt(params.get("product_id").get(i-click))));
//            }
//        }
        click = 0;
        return spec;
    }
}
