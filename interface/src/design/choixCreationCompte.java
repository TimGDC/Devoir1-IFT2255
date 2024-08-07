package design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class choixCreationCompte extends JFrame {


    private JPanel ecran3panel;
    private JRadioButton utilisateurRadioButton;
    private JRadioButton fournisseurRadioButton;

    public choixCreationCompte() {
        setContentPane(ecran3panel);
        setTitle("Creation de compte");
        setSize(300, 100); // Set the size of the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the close button is clicked
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
        utilisateurRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creationUtilisateur screen4 = new creationUtilisateur();
                screen4.show();
                dispose();
            }
        });
        fournisseurRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creationFournisseur screen5 = new creationFournisseur();
                screen5.show();
                dispose();
            }
        });
    }
}
