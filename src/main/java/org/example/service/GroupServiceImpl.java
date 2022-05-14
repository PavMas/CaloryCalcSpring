package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.ProductsGroup;
import org.example.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;

    @Override
    public ProductsGroup insert(String group_name) {
        return null;
    }

    @Override
    public List<ProductsGroup> getAll() {
        return groupRepository.findAll();
    }
}
