package adbistju.system.services;

import adbistju.system.models.product.Category;
import adbistju.system.repository.product.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<ArrayList<Category>> findAll(Specification<Category> spec) {
        return categoryRepository.findAll(spec);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
//    public Optional<Category> findByTitle(String title) {
//        return categoryRepository.findByTitle(title);
//    }
//
//    public Optional<Collection<Category>> findByTitle(Collection<String> title) {
//        return categoryRepository.findByTitle(title);
//    }
}
