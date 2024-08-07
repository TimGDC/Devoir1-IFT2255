package design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fonctionsFournisseur extends JFrame {
    private JPanel ecran10panel;
    private JTextField nouveauNomDUtilisateurTextField;
    private JTextField nouveauMotDePasseTextField;
    private JTextField nouvelleAdresseEmailTextField;
    private JTextField nouvelleAdresseDeLaTextField;
    private JTextField nouveauTypeDeComposanteTextField;
    private JTextField nouvelleQuantitéDeProductionTextField;
    private JButton gererButton;
    private JTextField nomDeLaComposanteTextField;
    private JTextField typeDeLaCompostaneTextField;
    private JTextField descriptionDeLaComposanteTextField;
    private JTextField prixDeLaComposanteTextField;
    private JButton validerButton;
    private JButton validerButton1;
    private JButton retournerAuMenuFournisseurButton;

    public fonctionsFournisseur() {
        setContentPane(ecran10panel);
        setTitle("Fonctions fournisseur");
        setSize(450, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the close button is clicked
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
        gererButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gererComposantes boutonGerer = new gererComposantes();
                boutonGerer.show();
                dispose();
            }
        });
        validerButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFournisseur retourMenu = new menuFournisseur();
                retourMenu.show();
                dispose();
            }
        });
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFournisseur retourMenu = new menuFournisseur();
                retourMenu.show();
                dispose();
            }
        });
        nouveauNomDUtilisateurTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = nouveauNomDUtilisateurTextField.getText();
            }
        });
        nouveauMotDePasseTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = nouveauMotDePasseTextField.getText();
            }
        });
        nouvelleAdresseEmailTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = nouvelleAdresseEmailTextField.getText();
            }
        });
        nouvelleAdresseDeLaTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = nouvelleAdresseDeLaTextField.getText();
            }
        });
        nouveauTypeDeComposanteTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = nouveauTypeDeComposanteTextField.getText();
            }
        });
        nouvelleQuantitéDeProductionTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = nouvelleQuantitéDeProductionTextField.getText();
            }
        });
        nomDeLaComposanteTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = nomDeLaComposanteTextField.getText();
            }
        });
        typeDeLaCompostaneTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = typeDeLaCompostaneTextField.getText();
            }
        });
        descriptionDeLaComposanteTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = descriptionDeLaComposanteTextField.getText();
            }
        });
        prixDeLaComposanteTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = prixDeLaComposanteTextField.getText();
            }
        });
        retournerAuMenuFournisseurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFournisseur retourMenu = new menuFournisseur();
                retourMenu.show();
                dispose();
            }
        });
    }

}


