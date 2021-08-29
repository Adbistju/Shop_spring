package adbistju.system.repository.specifications;

import adbistju.system.models.product.Product;
import adbistju.system.models.user.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;

public class UserSpecifications {

    private static Specification<User> emailLike(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("email"), String.format("%%%s%%", titlePart));
    }

    private static Specification<User> nameLike(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("username"), String.format("%%%s%%", titlePart));
    }

    private static Specification<User> idProduct(int idUser) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), idUser);
    }
//    private static Specification<Product> category(Category category) {
//        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("Category"), category);
//    }



    public static Specification<User> build(MultiValueMap<String, String> params) {
        int click = 0;
        Specification<User> spec = Specification.where(null);
        if (params.containsKey("email") && !params.getFirst("email").isBlank()) {
            spec = spec.and(UserSpecifications.emailLike(params.getFirst("email")));
            click++;
        }
        if (params.containsKey("username") && !params.getFirst("username").isBlank()) {
            spec = spec.and(UserSpecifications.nameLike(params.getFirst("username")));
            click++;
        }
        if (params.containsKey("user_id") && !params.getFirst("user_id").isBlank()) {
            String[] valueFilter = new String[params.get("user_id").size()-click];
            for (int i = click; i < valueFilter.length; i++) {
                spec = spec.or(UserSpecifications.idProduct(Integer.parseInt(params.get("user_id").get(i-click))));
            }
        }
        click = 0;
        return spec;
    }
}
