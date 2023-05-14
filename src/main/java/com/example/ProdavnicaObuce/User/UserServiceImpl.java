package com.example.ProdavnicaObuce.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(UserEntity user) {
        UserEntity user2 = new UserEntity();
        user2.setIme(user.getIme());
        user2.setPrezime(user.getPrezime());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setObuca(user.getObuca());
        user2.setUsername(user.getIme().substring(0, Math.min(user.getIme().length(), 2)) +
                user.getPrezime().substring(Math.max(user.getPrezime().length() - 3, 0)) +
                (int) (Math.random()*(10-1)) + 10);

        userRepository.save(user2);
    }

    @Override
    public List<UserEntity> getAllUseri() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Integer id, UserEntity user) {
        userRepository.findById(id)
                .ifPresent(noviUser -> {
                    noviUser.setIme(user.getIme());
                    noviUser.setPrezime(user.getPrezime());
                    noviUser.setEmail(user.getEmail());
                    noviUser.setUsername(user.getUsername());
                    noviUser.setPassword(user.getPassword());
                    noviUser.setObuca(user.getObuca());

                    userRepository.save(noviUser);
                });
    }
}
