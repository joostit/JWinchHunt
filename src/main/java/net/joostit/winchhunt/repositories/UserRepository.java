package net.joostit.winchhunt.repositories;

import net.joostit.winchhunt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
