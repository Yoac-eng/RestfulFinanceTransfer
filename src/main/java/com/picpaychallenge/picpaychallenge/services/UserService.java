package com.picpaychallenge.picpaychallenge.services;

import com.picpaychallenge.picpaychallenge.models.User;
import com.picpaychallenge.picpaychallenge.models.dto.UserDTO;

import java.util.List;



/**
 * User service interface.
 *
 * @author Cayo Cutrim
 * @since 17/08/2023
 */
public interface UserService {

    /**
     * Return all the users registered.
     *
     * @return List<UserDTO> A list containing all the registered UsersDTOs.
     */
    public List<UserDTO> findAll();
    /**
     * Register a new user.
     * @param newUser A new user to be created.
     * @return UserDTO The created UserDTO.
     */
    public UserDTO save(User newUser);
    /**
     * Find a user by id.
     * @param id The id of the user to be searched.
     * @return UserDTO The searched by ID userDTO.
     */
    public UserDTO findById(Long id);
    /**
     * Delete a user by id.
     * @param id The id of the user to be deleted.
     * @return
     */
    public void delete(Long id);
}
