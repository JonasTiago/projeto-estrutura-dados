package com.supermercado.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.supermercado.demo.dtos.UserDTO;
import com.supermercado.demo.models.UserModel;
import com.supermercado.demo.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    final UserService userService;
    private String userCpf;

	UserController(UserService userService) {
		this.userService = userService;
	}

    @GetMapping("/")
    public String home() { 
        return "index";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");

        List<UserModel> users = userService.findAll();

        mv.addObject( "users",users );

        return mv;
    }
    

    @PostMapping("/")
    public String createUser(@Valid UserDTO body) {
        
        userService.save(body);
        
        return "redirect:/list";
    }

    @PostMapping("/finds")
    public String findUser(@Valid String id) {
        return "redirect:/user";
    }
 
    @GetMapping("/search")
    public String getUserById(@RequestParam("cpf") String cpf) {

        userCpf = cpf;
        
        return "redirect:/user";
    }


    @GetMapping("/user")
    public ModelAndView findUser() {
        ModelAndView mv = new ModelAndView("list");

        List<UserModel> user = userService.findByCpf(userCpf);
        if( user.size() == 0 ) {
            List<UserModel> users = userService.findAll();

        mv.addObject("users", users);

        return mv;
        }

        mv.addObject("users", user);

        return mv;
    }

}
