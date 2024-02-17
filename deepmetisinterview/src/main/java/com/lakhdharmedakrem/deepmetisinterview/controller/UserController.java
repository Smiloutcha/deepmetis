package com.lakhdharmedakrem.deepmetisinterview.controller;

import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import com.lakhdharmedakrem.deepmetisinterview.service.ApplicationUserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final ApplicationUserService userService ;

    public UserController(ApplicationUserService userService){
        this.userService = userService;
    }



}
