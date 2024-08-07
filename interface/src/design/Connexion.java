package design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connexion extends JFrame {
    private JPanel panel1;
    private JButton confirmerButton;
    private JTextField textField1;
    private JTextField textField2;


    public Connexion() {
        setContentPane(panel1);
        setTitle("Se connecter");
        setSize(430, 350); // Set the size of the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the close button is clicked
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
        confirmerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal boutonConfirmer = new menuPrincipal();
                boutonConfirmer.show();
                dispose();
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField1.getText();
                JOptionPane.showMessageDialog(null, "You entered: " + text);
            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField2.getText();
            }
        });
    }

}
