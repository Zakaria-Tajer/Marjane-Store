package Marj.helper;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;


public class HashPassword {
    Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(32, 16, 1, 15 * 1024, 2);

    public String hashPassword(String password) {
        return encoder.encode(password);
    }

    public boolean validPassword(String password, String hashPassword){
        return encoder.matches(password, hashPassword);
    }


}
