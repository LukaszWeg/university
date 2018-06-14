package pl.lukasz.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukasz.university.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
