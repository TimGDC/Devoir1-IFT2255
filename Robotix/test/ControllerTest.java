package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Controller;
import main.User;

class ControllerTest {
    Controller controller;

    @BeforeEach
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void testAddUser() {
        User user = new User("testuser", "test@gmail.com", "password123");
        controller.addUser(user);
        assertTrue(controller.getUsers().contains(user));
    }

    @Test
    public void testRemoveUser() {
        User user = new User("testuser", "test@gmail.com", "password123");
        controller.addUser(user);
        controller.removeUser(user);
        assertFalse(controller.getUsers().contains(user));
    }
}