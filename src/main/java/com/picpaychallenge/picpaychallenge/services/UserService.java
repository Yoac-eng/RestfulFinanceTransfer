package com.picpaychallenge.picpaychallenge.services;

import com.picpaychallenge.picpaychallenge.entities.User;
import com.picpaychallenge.picpaychallenge.repositories.UserRepository;
import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        List<UserDTO> result = userRepository.findAll().stream().map(x -> new UserDTO(x)).toList();
        return result;
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User result = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return new UserDTO(result);
    }
}
