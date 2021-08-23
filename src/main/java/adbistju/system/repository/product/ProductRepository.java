package adbistju.system.repository.product;

import adbistju.system.models.product.Product;
import adbistju.system.models.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Page<Product> findAllBy(Pageable pageable);

    //@CreateNative
//    @Query(value = "SELECT pc FROM product_category as pc JOIN products, categories WHERE product_category.category_id IN ('4', '5', '6') AND products.id = product_category.product_id AND categories.id = product_category.category_id")
//    ArrayList<Product> findByCategoryId(/*@Param("sender") String sender, @Param("reciever") String reciever*/);
}