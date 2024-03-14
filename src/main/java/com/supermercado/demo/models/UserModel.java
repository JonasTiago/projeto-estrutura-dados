package com.supermercado.demo.models;


import com.supermercado.demo.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {

public UserModel(UserDTO dto){
        this.name = dto.getName();
        this.cpf = dto.getCpf();
        this.phone = dto.getPhone();
        this.email = dto.getEmail(); 
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 12, nullable = false)
    private String cpf;

    @Column()
    private String phone;

    @Column(nullable = false)
    private String email;
}
