package pl.borowik.akademia.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptGenerator {
    public static void main(String[] args) {
        String password = "pas";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        System.out.println(hashedPassword);
        password = "123";
        hashedPassword = passwordEncoder.encode(password);

        System.out.println(hashedPassword);
    }
}
