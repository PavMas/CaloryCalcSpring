package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final UserService userService;

    public void UserDemo(){
        List<User> userList = userService.getAll();
        System.out.println("=======");
        for (User user : userList) {
            System.out.println(user);
        }
        System.out.println("=======");
        System.out.println(userService.getByName("Андрей"));

    }
}
