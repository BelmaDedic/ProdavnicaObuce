package com.example.ProdavnicaObuce.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    public void addUser(@RequestBody UserEntity user) {
        userService.addUser(user);
    }

    @GetMapping("getAllUsers")
    public List<UserEntity> getAllUseri() {
        return userService.getAllUseri();
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);
    }

    @PutMapping("updateUser/{id}/{user}")
    public void updateUser(@PathVariable Integer id, @RequestBody UserEntity user) {
        userService.updateUser(id, user);
    }
}
