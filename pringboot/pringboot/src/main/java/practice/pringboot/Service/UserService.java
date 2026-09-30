package practice.pringboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import practice.pringboot.DTO.UserDTO;
import practice.pringboot.Entity.User;
import practice.pringboot.Repo.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(UserDTO dto) {

        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        String role = dto.getRole().trim().toUpperCase().replace("ROLE_","");

        user.setRole(role);

        userRepo.save(user);
        return "the " + dto.getUserName() + " as been added";
    }
}
