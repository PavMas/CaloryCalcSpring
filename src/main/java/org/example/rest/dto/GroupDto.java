package org.example.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.ProductsGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDto {
    private int id;
    private String group_name;
    private List<ProductDto> productList;

    public static GroupDto toDto(ProductsGroup group){
        List<ProductDto> productList1;
        if(group.getProductList() != null)
             productList1 = group.getProductList().stream().map(ProductDto::toDto).collect(Collectors.toList());
        else
            productList1 = new ArrayList<>();
        return new GroupDto(group.getId(), group.getGroup_name(), productList1);
    }
}
