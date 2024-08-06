package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.FournisseurController;
import main.Fournisseur;

class FournisseurControllerTest {
    FournisseurController fournisseurController;

    @BeforeEach
    public void setUp() {
        fournisseurController = new FournisseurController();
    }

    @Test
    public void testRegisterFournisseur() {
        Fournisseur fournisseur = new Fournisseur("Fourni", "fourni@gmail.com", "pass123");
        fournisseurController.registerFournisseur(fournisseur);
        assertTrue(fournisseurController.getFournisseurs().contains(fournisseur));
    }

    @Test
    public void testFindFournisseurByName() {
        Fournisseur fournisseur = new Fournisseur("Fourni", "fourni@gmail.com", "pass123");
        fournisseurController.registerFournisseur(fournisseur);
        assertEquals(fournisseur, fournisseurController.findFournisseurByName("Fourni"));
    }
}