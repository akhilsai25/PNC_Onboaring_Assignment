package com.pnc.onboarding.service;

import com.pnc.onboarding.domain.User;
import com.pnc.onboarding.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


    public List<User> getUsers() {

        return usersRepository.findAll();
    }

    public Optional<User> getUserById(long id) {

        return usersRepository.findById(id);
    }

    public List<User> saveUsers(List<User> users) {
        return usersRepository.saveAll(users);
    }

    public User saveUser(User user) {
        return usersRepository.save(user);
    }
}
