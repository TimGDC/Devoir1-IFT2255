package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Robot;

class RobotTest {
    Robot robot;

    @BeforeEach
    public void setUp() {
        robot = new Robot("Robox", "TypeA", 100);
    }

    @Test
    public void testUpdatePosition() {
        robot.updatePosition(50, 50);
        assertEquals(50, robot.getPositionX());
        assertEquals(50, robot.getPositionY());
    }

    @Test
    public void testBatteryLevel() {
        robot.setBatteryLevel(80);
        assertEquals(80, robot.getBatteryLevel());
    }
}