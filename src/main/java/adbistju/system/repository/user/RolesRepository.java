package adbistju.system.repository.user;

import adbistju.system.models.user.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RolesRepository extends CrudRepository<Role, Long> {
    Optional<Role> findById(Long id);
}
