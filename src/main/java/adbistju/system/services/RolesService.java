package adbistju.system.services;

import adbistju.system.models.user.Role;
import adbistju.system.repository.user.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolesService {
    private final RolesRepository rolesRepository;

    public Optional<Role> findById(Long id) {
        return rolesRepository.findById(id);
    }
}