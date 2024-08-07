package design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuUtilisateur extends JFrame {
    private JPanel panelMenuUser;
    private JButton requetesPubliquesButton;
    private JButton fonctionnalitesPourUtilisateursButton;

    public menuUtilisateur() {
        setContentPane(panelMenuUser);
        setTitle("Menu utilisateur");
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
        fonctionnalitesPourUtilisateursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fonctionsUtilisateurs boutonFonctionsUsers = new fonctionsUtilisateurs();
                boutonFonctionsUsers.show();
                dispose();
            }
        });
    }
}
