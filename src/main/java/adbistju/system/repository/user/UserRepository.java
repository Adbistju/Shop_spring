package adbistju.system.repository.user;

import adbistju.system.models.user.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;//ф
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;//ф
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
