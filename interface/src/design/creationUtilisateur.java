package design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class creationUtilisateur extends JFrame {
    private JPanel ecran4panel;
    private JCheckBox voulezVousRecevoirLesCheckBox;
    private JButton creerButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public creationUtilisateur() {
        setContentPane(ecran4panel);
        setTitle("Creation d'un compte d'utilisateur");
        setSize(300, 300); // Set the size of the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the close button is clicked
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
        creerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bienvenue boutonCreerUtilisateur = new Bienvenue();
                boutonCreerUtilisateur.show();
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
    }
}
