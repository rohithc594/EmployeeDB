package practice.pringboot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.pringboot.Entity.User;

public interface UserRepo extends JpaRepository<User , Long> {
    User findByUserName(String username);
}
