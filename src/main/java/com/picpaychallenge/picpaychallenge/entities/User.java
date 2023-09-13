package com.picpaychallenge.picpaychallenge.entities;

import com.picpaychallenge.picpaychallenge.enums.UserType;
import jakarta.persistence.*;
import lombok.*;
import org.mindrot.jbcrypt.BCrypt;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class that maps the users table.
 *
 * @author Cayo Cutrim, 17/08/2023
 *
 */
@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String name;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String passwordHash;

    private BigDecimal balance;

    // Methods that will encrypt the password and check it when needed
    public void setPassword(String password) {
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public boolean verifyPassword(String password) {
        return BCrypt.checkpw(password, this.passwordHash);
    }
}
