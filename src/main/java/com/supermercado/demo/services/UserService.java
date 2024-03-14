package com.supermercado.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supermercado.demo.dtos.UserDTO;
import com.supermercado.demo.models.UserModel;
import com.supermercado.demo.repositories.UserRepository;

@Service
public class UserService {
    
    final UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserModel save(UserDTO dto){
        UserModel user = new UserModel(dto);
        return userRepository.save(user);
    }

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    public List<UserModel> findByCpf(String cpf){
        return userRepository.findByCpf(cpf);
    }
}
