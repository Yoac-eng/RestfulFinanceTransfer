package com.picpaychallenge.picpaychallenge.entities;

import com.picpaychallenge.picpaychallenge.enums.UserType;
import jakarta.persistence.*;
import lombok.*;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(of = {"id", "email"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UserType userType;
    private String name;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String cnpj;
    @Column(unique = true)
    private String email;
    private String password;
    private Double wallet;

    // Methods that will encrypt the password and check it when needed
    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public boolean verifyPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }
}
