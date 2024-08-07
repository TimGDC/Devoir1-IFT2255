package design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gererComposantes extends JFrame {
    private JPanel ecran11panel;
    private JButton afficherMesComposantesButton;
    private JTextField indexDeLaComposanteTextField;
    private JTextField indexDeLaComposanteTextField1;
    private JTextField nomDeLaComposanteTextField;
    private JTextField typeDeLaComposanteTextField;
    private JTextField descritpionDeLaComposanteTextField;
    private JTextField prixDeLaComposanteTextField;
    private JButton validerButton;
    private JButton retourAuMenuFournisseurButton;

    public gererComposantes() {
        setContentPane(ecran11panel);
        setTitle("Gerer composantes");
        setSize(500, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the close button is clicked
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
        afficherMesComposantesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete resultComposantes = new resultatRequete();
                resultComposantes.show();
                dispose();
            }
        });
        indexDeLaComposanteTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuUtilisateur resultatSupprimer = new menuUtilisateur();
                resultatSupprimer.show();
                dispose();
            }
        });
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuUtilisateur resultatValider = new menuUtilisateur();
                resultatValider.show();
                dispose();
            }
        });
        indexDeLaComposanteTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = indexDeLaComposanteTextField1.getText();
            }
        });
        nomDeLaComposanteTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = nomDeLaComposanteTextField.getText();
            }
        });
        typeDeLaComposanteTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = typeDeLaComposanteTextField.getText();
            }
        });
        descritpionDeLaComposanteTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = descritpionDeLaComposanteTextField.getText();
            }
        });
        prixDeLaComposanteTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = prixDeLaComposanteTextField.getText();
            }
        });
        retourAuMenuFournisseurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFournisseur retourMenuFournisseur = new menuFournisseur();
                retourMenuFournisseur.show();
                dispose();
            }
        });
    }
}
