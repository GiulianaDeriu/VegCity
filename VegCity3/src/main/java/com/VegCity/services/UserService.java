package com.VegCity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VegCity.model.User;
import com.VegCity.model.entity.UserEntity;
import com.VegCity.repository.UserRepository;
import com.VegCity.utility.Utility;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Utility utility;

    public Object registrazione(User user) throws Exception {

        Optional<List<UserEntity>> userEntityList = userRepository.findByUsernameOrEmail(user.getName(),
                user.getMail());

        UserEntity userEntity;
        if (!userEntityList.get().isEmpty()) {
            throw new Exception("Username or email already in use");
        } else {
            userEntity = utility.convertUser(user);
            if (userEntity != null) {
                System.out.println("mi sto registrando");
                userRepository.save(userEntity);
            }
        }
        return user;
    }

    public User login(String userName, String password) throws Exception {
        User u = new User();

        Optional<UserEntity> userEntity = userRepository.findByUsername(userName);

        if (userEntity.isPresent() && password != null && password.equals(userEntity.get().getPassword())) {
            u = utility.toUser(userEntity.get());
        } else {
            throw new Exception("Username or password not compliant");
        }
        return u;
    }

}
