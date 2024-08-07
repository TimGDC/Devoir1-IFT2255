package design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class creationFournisseur extends JFrame {
    private JPanel ecran5panel;
    private JButton creerButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField veuillezEntrerSoit1TextField;
    private JCheckBox voulezVousRecevoirLesCheckBox;

    public creationFournisseur() {
        setContentPane(ecran5panel);
        setTitle("Creation d'un compte de fournisseur");
        setSize(400, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the close button is clicked
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
        creerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bienvenue boutonCreerFournisseur = new Bienvenue();
                boutonCreerFournisseur.show();
                dispose();
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField1.getText();
            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField2.getText();
            }
        });
        textField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField3.getText();
            }
        });
        textField4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField4.getText();
            }
        });
        textField5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField5.getText();
            }
        });
        veuillezEntrerSoit1TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField5.getText();
            }
        });
    }
}
