package entities;

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
    private String name;
    private String cpf;
    private String cnpj;
    private String email;
    private String passwordHash;
    private Double wallet;

    // Methods that will encrypt the password and check it when needed
    public void setPassword(String password) {
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public boolean verifyPassword(String password) {
        return BCrypt.checkpw(password, this.passwordHash);
    }
}
