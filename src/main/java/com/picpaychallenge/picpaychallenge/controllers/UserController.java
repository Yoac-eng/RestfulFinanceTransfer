package com.picpaychallenge.picpaychallenge.controllers;

import com.picpaychallenge.picpaychallenge.services.UserService;
import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<UserDTO> findAll(){
        List<UserDTO> result = userService.findAll();
        return result;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        try {
            UserDTO result = userService.findById(id);
            return ResponseEntity.ok(result);
        }
        catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
