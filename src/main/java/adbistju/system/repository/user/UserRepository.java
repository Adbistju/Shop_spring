package adbistju.system.repository.user;

import adbistju.system.models.product.Product;
import adbistju.system.models.user.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;//ф
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;//ф
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{
    Optional<User> findByUsername(String username);

    Page<User> findAllBy(Pageable pageable);
}
