package org.example.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.Meal;
import org.example.domain.ProductItem;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductItemDto {

    private int id;
    private String name;
    private float weight;
    private float value;

    public static ProductItemDto toDto(ProductItem product){
        return new ProductItemDto(product.getId(), product.getName(), product.getWeight(), product.getValue());
    }

    public static ProductItem toDomainObject(ProductItem productDto, Meal meal){
        return new ProductItem(productDto.getId(), productDto.getName(), productDto.getValue(), productDto.getWeight(), meal);
    }
}
