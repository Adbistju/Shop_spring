package adbistju.system.dtos;


import adbistju.system.facade.CategoryFacade;
import adbistju.system.models.product.Category;
import adbistju.system.models.product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

//    @Size(min = 4, max = 255, message = "Title size: 4-255")
    private String title;

//    @Min(value = 1, message = "Min price = 1")
    private BigDecimal price;

    private Collection<Category/*Dto*/> categoryTitle;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.categoryTitle = product.getCategories()/*.stream().map(categoryFacade::categoryToCategoryDTO).collect(Collectors.toList())*/;
    }
}
