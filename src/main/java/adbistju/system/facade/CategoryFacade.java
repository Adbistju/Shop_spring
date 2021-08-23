package adbistju.system.facade;

import adbistju.system.dtos.CategoryDto;
import adbistju.system.dtos.ProductDto;
import adbistju.system.models.product.Category;
import adbistju.system.models.product.Product;
import org.springframework.stereotype.Component;

@Component
public class CategoryFacade {

    public CategoryDto categoryToCategoryDTO(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(categoryDto.getId());
        categoryDto.setTitle(categoryDto.getTitle());
        return categoryDto;
    }

}
