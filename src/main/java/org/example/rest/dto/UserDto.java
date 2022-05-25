package org.example.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.Meal;
import org.example.domain.User;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private int id;
    private String name;
    private String password;



    public static UserDto toDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getPassword());
    }

    public static User toDomainObject(UserDto userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getPassword());
    }
}
