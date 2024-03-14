package com.supermercado.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermercado.demo.models.UserModel;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    List<UserModel> findByCpf(String cpf);
} 
