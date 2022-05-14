package org.example.repository;

import org.example.domain.ProductsGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<ProductsGroup, Integer> {

    //ProductsGroup findByName(String group_name);
}
