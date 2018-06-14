package pl.lukasz.university;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.lukasz.university.entity.User;
import pl.lukasz.university.repository.UserRepository;
import pl.lukasz.university.service.RoleService;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    private PasswordEncoder passwordEncoder;
    private RoleService roleService;
    private UserRepository userRepository;

    public UniversityApplication(PasswordEncoder passwordEncoder, RoleService roleService, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
