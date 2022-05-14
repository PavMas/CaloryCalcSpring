package org.example.rest.controller;


import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.rest.dto.UserDto;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping("/user")
    public List<UserDto> getUsers(){
        return userService
                .getAll()
                .stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());
    }
    @PostMapping("/user")
    public UserDto createNewUser(@RequestBody UserDto dto){
        User user = userService.insert(UserDto.toDomainObject(dto));
        return UserDto.toDto(user);
    }

}