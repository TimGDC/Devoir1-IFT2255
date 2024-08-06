package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Fournisseur;
import main.Composante;

class FournisseurTest {
    Fournisseur fournisseur;

    @BeforeEach
    public void setUp() {
        fournisseur = new Fournisseur("Amaxon", "amaxon@gmail.com", "123");
    }

    @Test
    public void testAddComposante() {
        Composante composante = new Composante("SUPERCPU", "CPU", 1599);
        fournisseur.addComposante(composante);
        assertTrue(fournisseur.getComposantes().contains(composante));
    }

    @Test
    public void testRemoveComposante() {
        Composante composante = new Composante("SUPERCPU", "CPU", 1599);
        fournisseur.addComposante(composante);
        fournisseur.removeComposante(composante);
        assertFalse(fournisseur.getComposantes().contains(composante));
    }
}