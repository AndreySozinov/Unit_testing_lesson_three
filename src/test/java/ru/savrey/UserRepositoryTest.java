package ru.savrey;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    UserRepository repo = new UserRepository();

    @BeforeEach
    void setup() {
         User user1 = new User("Vasya", "12345");
         User user2 = new User("Petya", "54321");
         User user3 = new User("root", "pass", true);
         User user4 = new User("admin", "admin");

        user1.authenticate("Vasya", "12345");
        user2.authenticate("Petya", "54321");
        user3.authenticate("root", "pass");
        user4.authenticate("admin", "admin");

        repo.addUser(user1);
        repo.addUser(user2);
        repo.addUser(user3);
        repo.addUser(user4);

        repo.allLogoutExceptAdmin();
    }

    @Test
    void findNotAdmin() {
        assertFalse(repo.findByName("Vasya"));
    }

    @Test
    void findAdmin() {
        assertTrue(repo.findByName("root"));
    }
}
