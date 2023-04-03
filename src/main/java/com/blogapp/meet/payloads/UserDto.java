package com.blogapp.meet.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 3, message = "User name must be min of 3 character ")
    private String name;

    @Email(message = "Email address is not valid !!")
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String about;

}
