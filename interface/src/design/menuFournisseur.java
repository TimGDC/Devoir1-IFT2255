package design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuFournisseur extends JFrame {
    private JButton panelMenuFournisseur;
    private JButton requetesPubliquesButton;
    private JButton fonctionnalitesPourFournisseursButton;

    public menuFournisseur() {
        setContentPane(panelMenuFournisseur);
        setTitle("Menu fournisseur");
        setSize(300, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the close button is clicked
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible

        requetesPubliquesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requetesPubliques boutonRequetesPubliques = new requetesPubliques();
                boutonRequetesPubliques.show();
                dispose();
            }
        });
        fonctionnalitesPourFournisseursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fonctionsFournisseur boutonFonctionnalitesFournisseur = new fonctionsFournisseur();
                boutonFonctionnalitesFournisseur.show();
                dispose();
            }
        });
    }
}
