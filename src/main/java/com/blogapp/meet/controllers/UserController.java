package com.blogapp.meet.controllers;

import com.blogapp.meet.payloads.ApiResponse;
import com.blogapp.meet.payloads.UserDto;
import com.blogapp.meet.repositories.UserRepo;
import com.blogapp.meet.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

//    @GetMapping("/")
//    public List<UserDto> getAllUser(){
//        List<UserDto> getAllUserDto = this.userService.getAllUsers();
//        return getAllUserDto;
//    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }


//    @GetMapping("/{userId}")
//    public ResponseEntity<UserDto> getById(@PathVariable()Integer userId){
//        UserDto getUserById = this.userService.getUserById(userId);
//        return new ResponseEntity<>(getUserById,HttpStatus.OK);
//    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId){

        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){

        this.userService.deleteUser(userId);
        //return new ResponseEntity<>(Map.of("Message","User deleted successfully"),HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse("User Deleted successfully",true),HttpStatus.OK);

    }



}
