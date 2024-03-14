package com.supermercado.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    
    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @NotBlank 
    private String cpf;

    @NotBlank
    @Email
    private String email;
}
