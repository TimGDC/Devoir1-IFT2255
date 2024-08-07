package design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenue extends JFrame {
    private JPanel panelMain;
    private JButton seConnecterButton;
    private JButton sInscrireButton;
    private JTextField txtName;
    private JButton btnClick;


    public Bienvenue() {

        setContentPane(panelMain);
        setTitle("Robotix");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        seConnecterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connexion screen = new Connexion();
                screen.show();
                dispose();


            }
        });
        sInscrireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixCreationCompte screen3 = new choixCreationCompte();
                screen3.show();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Bienvenue h = new Bienvenue();
        h.setVisible(true);
        h.setResizable(false);

    }
}
