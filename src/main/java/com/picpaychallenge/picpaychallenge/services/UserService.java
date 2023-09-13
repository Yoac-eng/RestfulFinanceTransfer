package com.picpaychallenge.picpaychallenge.services;

import com.picpaychallenge.picpaychallenge.entities.User;
import com.picpaychallenge.picpaychallenge.dto.UserDTO;

import java.util.List;



public interface UserService {

    public List<UserDTO> findAll();
    public UserDTO save(User newUser);
    public UserDTO findById(Long id);
}
