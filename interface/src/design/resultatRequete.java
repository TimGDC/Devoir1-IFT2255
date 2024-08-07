package design;

import javax.swing.*;

public class resultatRequete extends JFrame {
    private JPanel panel1;
    private JTextArea iciSeTrouveLeTextArea;

    public resultatRequete() {
        setContentPane(panel1);
        setTitle("Resultat de requete");
        setSize(800, 800); // Set the size of the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the close button is clicked
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible

    }

}
