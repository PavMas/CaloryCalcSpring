package org.example.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.Product;
import org.example.domain.ProductsGroup;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private int id;
    private String name;
    private float value;

    public static ProductDto toDto(Product product){
        return new ProductDto(product.getId(), product.getName(), product.getValue());
    }

    public static Product toDomainObject(ProductDto productDto, ProductsGroup group){
        return new Product(productDto.getId(), productDto.getName(), productDto.getValue(), group);
    }
}
