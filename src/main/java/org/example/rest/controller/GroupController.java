package org.example.rest.controller;


import lombok.RequiredArgsConstructor;
import org.example.repository.GroupRepository;
import org.example.rest.dto.GroupDto;
import org.example.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/groups")
    public List<GroupDto> getAllGroups(){
        List<GroupDto> groupDtoList = groupService.getAll().stream().map(GroupDto::toDto).collect(Collectors.toList());
        return groupDtoList;
    }
}
