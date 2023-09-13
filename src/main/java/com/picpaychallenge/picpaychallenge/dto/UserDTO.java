package com.picpaychallenge.picpaychallenge.dto;

import com.picpaychallenge.picpaychallenge.entities.User;
import com.picpaychallenge.picpaychallenge.enums.UserType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * User DTO class.
 *
 * @author Cayo Cutrim, 17/08/2023
 *
 */
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private UserType userType;
    private String name;
    private String document;
    private String email;
    private BigDecimal balance;

    // Used to prevent boilerplate, copying properties from the constructor direct on the dto
    public UserDTO(User entity){
        BeanUtils.copyProperties(entity, this);
    }
}



