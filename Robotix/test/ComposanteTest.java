package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Composante;

class ComposanteTest {
    Composante composante;

    @BeforeEach
    public void setUp() {
        composante = new Composante("SUPERCPU", "CPU", 1599);
    }

    @Test
    public void testUpdatePrice() {
        composante.updatePrice(1499);
        assertEquals(1499, composante.getPrice());
    }

    @Test
    public void testUpdateDescription() {
        composante.updateDescription("New generation CPU");
        assertEquals("New generation CPU", composante.getDescription());
    }
}