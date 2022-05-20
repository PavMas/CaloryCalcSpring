package org.example.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.Meal;
import org.example.domain.ProductsGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealDto {

    private int id;
    private String name;
    private int uid;
    private List<ProductItemDto> list;

    public static MealDto toDto(Meal meal){
        List<ProductItemDto> productList1;
        if(meal.getProductItems() != null)
            productList1 = meal.getProductItems().stream().map(ProductItemDto::toDto).collect(Collectors.toList());
        else
            productList1 = new ArrayList<>();
        return new MealDto(meal.getId(), meal.getName(), meal.getUser().getId(), productList1);
    }

}
