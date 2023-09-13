package com.picpaychallenge.picpaychallenge.services.impl;

import com.picpaychallenge.picpaychallenge.entities.User;
import com.picpaychallenge.picpaychallenge.repositories.UserRepository;
import com.picpaychallenge.picpaychallenge.services.UserService;
import com.picpaychallenge.picpaychallenge.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        List<UserDTO> result = userRepository.findAll().stream().map(x -> new UserDTO(x)).toList();
        return result;
    }

    public UserDTO save(User newUser){
        try{
            UserDTO result = new UserDTO(userRepository.save(newUser));
            return result;
        }catch (Exception e){
            throw new IllegalArgumentException("A unique key constraint is being violated");
        }
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User result = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return new UserDTO(result);
    }
}
