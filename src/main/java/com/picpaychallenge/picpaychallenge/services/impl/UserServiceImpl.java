package com.picpaychallenge.picpaychallenge.services.impl;

import com.picpaychallenge.picpaychallenge.exception.DuplicateFieldException;
import com.picpaychallenge.picpaychallenge.exception.InvalidFieldException;
import com.picpaychallenge.picpaychallenge.models.User;
import com.picpaychallenge.picpaychallenge.exception.RequiredObjectIsNullException;
import com.picpaychallenge.picpaychallenge.exception.ResourceNotFoundException;
import com.picpaychallenge.picpaychallenge.models.repositories.UserRepository;
import com.picpaychallenge.picpaychallenge.services.UserService;
import com.picpaychallenge.picpaychallenge.models.dto.UserDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        List<UserDTO> result = userRepository.findAll().stream().map(x -> new UserDTO(x)).toList();
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User result = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by the given id"));
        return new UserDTO(result);
    }

    @Override
    @Transactional
    public UserDTO save(User newUser){
        validate(newUser);

        newUser.setPassword(newUser.getPasswordHash());
        UserDTO result = new UserDTO(userRepository.save(newUser));
        return result;
    }

    @Override
    @Transactional
    public void delete(Long id){
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by the given id"));

        userRepository.delete(entity);
    }

    /**
     * Validate the given user.
     * @param user
     */
    public void validate(User user){

        if (user == null) {
            throw new RequiredObjectIsNullException("A empty user cant be created");
        }
        if (StringUtils.isEmpty(user.getName())) {
            throw new InvalidFieldException("A username is required.");
        }
        if (user.getDocument() == null){
            throw new InvalidFieldException("A document is required");
        }
        if (StringUtils.isEmpty(user.getEmail())){
            throw new InvalidFieldException("A email is required");
        }
        if (user.getPasswordHash() == null){
            throw new InvalidFieldException("A password is required");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateFieldException("Email address is already in use");
        }
        if(userRepository.existsByDocument(user.getDocument())){
            throw new DuplicateFieldException("This document id is already in use");
        }
    }
}
