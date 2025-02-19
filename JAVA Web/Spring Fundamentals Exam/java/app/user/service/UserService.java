package app.user.service;

import app.user.model.User;
import app.user.repository.UserRepository;
import app.web.dto.EditProfile;
import app.web.dto.LoginRequest;
import app.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest registerRequest) {

        Optional<User> userOptional = this.userRepository.findByUsername(registerRequest.getUsername());

        if (userOptional.isPresent()) {
            throw new RuntimeException("Username already exists!");
        }

        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        this.userRepository.save(user);

    }

    public User login(LoginRequest loginRequest) {
        Optional<User> byUsername = this.userRepository.findByUsername(loginRequest.getUsername());

        if (byUsername.isEmpty()) {
            throw new RuntimeException("Username or password incorrect!");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), byUsername.get().getPassword())) {
            throw new RuntimeException("Username or password incorrect!");
        }

        return byUsername.get();
    }


    public User getById(UUID userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public void updateUserProfile(UUID userId, EditProfile editProfile) {
        User user = getById(userId);

        user.setFirstName(editProfile.getFirstName().isEmpty() ? null : editProfile.getFirstName());
        user.setLastName(editProfile.getLastName().isEmpty() ? null : editProfile.getLastName());
        user.setEmail(editProfile.getEmail().isEmpty() ? null : editProfile.getEmail());
        user.setProfilePicture(editProfile.getProfilePicture().isEmpty() ? null : editProfile.getProfilePicture());

        this.userRepository.save(user);
    }
}
