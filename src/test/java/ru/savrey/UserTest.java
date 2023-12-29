package ru.savrey;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    User user;
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        user = new User("root", "admin");
        userRepository = new UserRepository();
    }

    @Test
    void positiveUserAuthentication() {
        assertTrue(user.authenticate("root", "admin"));
    }

    @ParameterizedTest
    @CsvSource({"admin, admin", "root, root", "user, user"})
    void negativeUserAuthentication(String name, String password) {
        assertFalse(user.authenticate(name, password));
    }

    @Test
    void positiveAddingToUserRepository() {
        user.authenticate("root", "admin");
        userRepository.addUser(user);
        assertTrue(userRepository.findByName(user.name));
    }

    @Test
    void negativeAddingToUserRepository() {
        user.authenticate("admin", "admin");
        userRepository.addUser(user);
        assertFalse(userRepository.findByName(user.name));
    }
}
