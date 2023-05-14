package com.example.ProdavnicaObuce.User;

import java.util.List;

public interface UserService {
    void addUser(UserEntity user);

    List<UserEntity> getAllUseri();

    void deleteUser(Integer id);

    void updateUser(Integer id, UserEntity user);
}
