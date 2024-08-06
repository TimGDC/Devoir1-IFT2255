package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Activite;

class ActiviteTest {
    Activite activite;

    @BeforeEach
    public void setUp() {
        activite = new Activite("Cinema", "2024-08-01", "Pending");
    }

    @Test
    public void testChangeStatus() {
        activite.changeStatus("Completed");
        assertEquals("Completed", activite.getStatus());
    }

    @Test
    public void testUpdateDate() {
        activite.updateDate("2024-08-15");
        assertEquals("2024-08-15", activite.getDate());
    }
}