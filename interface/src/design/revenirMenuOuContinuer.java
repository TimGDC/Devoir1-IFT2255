package design;

import javax.swing.*;

public class revenirMenuOuContinuer extends JFrame {
    private JPanel ecran8panel;
    private JButton revenirAuMenuPrécédentButton;
    private JButton quitterLApplicationButton;


    public revenirMenuOuContinuer() {
        setContentPane(ecran8panel);
        setTitle("Revenir ou continuer");
        setSize(300, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the close button is clicked
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
    }
}
