package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserControllerTest {
    UserController userController;

    @BeforeEach
    public void setUp() {
        userController = new UserController();
    }

    @Test
    public void testRegisterUser() {
        User user = new User("newUser", "newuser@gmail.com", "pass123");
        userController.registerUser(user);
        assertTrue(userController.getUsers().contains(user));
    }

    @Test
    public void testAuthenticateUser() {
        User user = new User("newUser", "newuser@gmail.com", "pass123");
        userController.registerUser(user);
        assertTrue(userController.authenticate("newuser@gmail.com", "pass123"));
    }
}