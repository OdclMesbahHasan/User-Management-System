package com.mesbah.UserManagement.service;

import com.mesbah.UserManagement.entity.UserEntity;
import com.mesbah.UserManagement.model.User;
import com.mesbah.UserManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        //userEntity.setId(user.getId());
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            User user = new User();
            user.setFirstName(userEntity.getFirstName());
            user.setLastName(userEntity.getLastName());
            //user.setId(userEntity.getId());
            users.add(user);
        }
        return users;
    }

    @Override
    public User getUserById(Long id) {
        User user = null;
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            user = new User();
            user.setFirstName(userEntity.get().getFirstName());
            user.setLastName(userEntity.get().getLastName());
            user.setEmail(userEntity.get().getEmail());
           // user.setId(userEntity.get().getId());
        }
        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            userRepository.delete(userEntity);
        }
        return true;
    }

    @Override
    public User updateUser(Long id, User user) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setEmail(user.getEmail());
            userRepository.save(userEntity);
        }
        return user;
    }
}
