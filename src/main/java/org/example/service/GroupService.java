package org.example.service;

import org.example.domain.ProductsGroup;

import java.util.List;

public interface GroupService {

    ProductsGroup insert(String group_name);
    List<ProductsGroup> getAll();
}
