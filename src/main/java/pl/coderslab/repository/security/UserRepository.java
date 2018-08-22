package pl.coderslab.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    void delete(User user);
    User findByUsername(String name);
}