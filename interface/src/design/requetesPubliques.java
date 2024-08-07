package design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class requetesPubliques extends JFrame {
    private JPanel ecran7panel;
    private JTextField veuillezEntrerUnNomTextField;
    private JTextField veuillezEntrerUnNomTextField1;
    private JButton récupérerLaListeDesButton;
    private JButton récupérerLaListeDesButton1;
    private JTextField veuillezEntrerUnNomTextField2;
    private JButton récupérerLaListeDesButton2;
    private JTextField veuillezEntrerUnNomTextField4;
    private JTextField veuillezEntrerUnNomTextField5;

    public requetesPubliques() {
        setContentPane(ecran7panel);
        setTitle("Requetes publiques");
        setSize(670, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the close button is clicked
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
        récupérerLaListeDesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete listUser = new resultatRequete();
                listUser.show();
                dispose();
            }
        });
        récupérerLaListeDesButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete listUser = new resultatRequete();
                listUser.show();
                dispose();
            }
        });
        récupérerLaListeDesButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete listUser = new resultatRequete();
                listUser.show();
                dispose();
            }
        });
        veuillezEntrerUnNomTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete listUser = new resultatRequete();
                listUser.show();
                dispose();
            }
        });
        veuillezEntrerUnNomTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete listUser = new resultatRequete();
                listUser.show();
                dispose();
            }
        });
        veuillezEntrerUnNomTextField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete listUser = new resultatRequete();
                listUser.show();
                dispose();
            }
        });
        veuillezEntrerUnNomTextField4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete listUser = new resultatRequete();
                listUser.show();
                dispose();
            }
        });
        veuillezEntrerUnNomTextField5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete listUser = new resultatRequete();
                listUser.show();
                dispose();
            }
        });
    }
}
