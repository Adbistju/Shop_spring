package adbistju.system.facade;

import adbistju.system.models.product.Product;
import org.springframework.stereotype.Component;
import adbistju.system.dtos.ProductDto;

@Component
public class ProductFacade {

    public ProductDto productDtoToProductDTO(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setTitle(product.getTitle());
        return productDto;
    }


}
