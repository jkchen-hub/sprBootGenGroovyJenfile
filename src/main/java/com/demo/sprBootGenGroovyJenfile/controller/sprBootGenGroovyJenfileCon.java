package com.demo.sprBootGenGroovyJenfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sprBootGenGroovyJenfile.entity.UserVO;

@RestController
public class sprBootGenGroovyJenfileCon {
	
    @RequestMapping("welcome")
    public String welcome(UserVO user){
        System.out.println("POJO: " + user.getClass().getName() + 
                ", hash code: " + user.hashCode() + ", " + user.toString());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "redirect:/";
        
    }
}