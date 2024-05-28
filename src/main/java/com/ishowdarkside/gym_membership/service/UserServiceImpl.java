package com.ishowdarkside.gym_membership.service;


import com.ishowdarkside.gym_membership.entity.User;
import com.ishowdarkside.gym_membership.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    final private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        return this.userRepository.createUser(user);
    }
}
