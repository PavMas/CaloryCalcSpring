package org.example.rest.controller;


import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.rest.dto.MealDto;
import org.example.rest.dto.UserDto;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
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
    public UserDto createNewUser(@RequestParam String name, @RequestParam String password){
        User user = userService.insert(name, password);
        return UserDto.toDto(user);
    }
    @GetMapping("/user/{name}")
    @Transactional
    public UserDto getUserById(@PathVariable String name) {

        return UserDto.toDto(userService.getByName(name));
    }

    @DeleteMapping("/user/{id}")
    @Transactional
    public void deleteUserByName(@PathVariable int id) {
        userService.deleteById(id);
    }

}
