package com.picpaychallenge.picpaychallenge.controllers;

import com.picpaychallenge.picpaychallenge.models.User;
import com.picpaychallenge.picpaychallenge.services.UserService;
import com.picpaychallenge.picpaychallenge.models.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Default controller to handle User related requests.
 *
 * @author Cayo Cutrim
 * @since 17/08/2023
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Return all the users registered.
     *
     * @return List<UserDTO> A list containing all the registered UsersDTOs.
     */
    @GetMapping
    public List<UserDTO> findAll(){
        List<UserDTO> result = userService.findAll();
        return result;
    }

    /**
     * Create a new user.
     * @param newUser The user object containing the details of the user to be created.
     * @return ResponseEntity<UserDTO> The ResponseEntity containing the newly created UserDTO.
     */
    @PostMapping
    public ResponseEntity<UserDTO> newUser(@RequestBody User newUser){
        UserDTO result = userService.save(newUser);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Find a user by id.
     * @param id The id of the user to be searched.
     * @return ResponseEntity<UserDTO> The ResponseEntity containing the searched by id UserDTO.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        UserDTO result = userService.findById(id);
        return ResponseEntity.ok(result);
    }

    /**
     * Delete a user by id;
     * @param id The id of the user to be deleted.
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
