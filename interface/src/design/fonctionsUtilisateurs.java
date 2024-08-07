package design;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fonctionsUtilisateurs extends JFrame {
    private JPanel panelfonctions2;
    private JTextField nouveauNomDUtilisateurTextField;
    private JTextField nouveauMotDePasseTextField;
    private JTextField nouveauEmailTextField;
    private JButton afficherDesRobotsButton;
    private JTextField nomTextField;
    private JTextField numéroDeSérieTextField1;
    private JTextField nomDuRobotATextField;
    private JButton afficherActivitesButton;
    private JTextField nomDeLActiviteTextField;
    private JTextField nomDeLActiviteTextField1;
    private JButton afficherVueGeneraleButton;
    private JButton afficherVueCompleteButton;
    private JTextField veuillezEntrerUnNombreTextField;
    private JButton validerButton;
    private JButton validerButton1;
    private JButton retourAuMenuUtilisateurButton;


    public fonctionsUtilisateurs() {
        setContentPane(panelfonctions2);
        setTitle("Fonctions utilisateurs");
        setSize(800, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the close button is clicked
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuUtilisateur retourMenu = new menuUtilisateur();
                retourMenu.show();
                dispose();
            }
        });
        afficherDesRobotsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete resultBouton = new resultatRequete();
                resultBouton.show();
                dispose();
            }
        });
        afficherActivitesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete resultBouton = new resultatRequete();
                resultBouton.show();
                dispose();
            }
        });
        afficherVueGeneraleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete resultBouton = new resultatRequete();
                resultBouton.show();
                dispose();
            }
        });
        afficherVueCompleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete resultBouton = new resultatRequete();
                resultBouton.show();
                dispose();
            }
        });
        veuillezEntrerUnNombreTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultatRequete resultBouton = new resultatRequete();
                resultBouton.show();
                dispose();
            }
        });
        nomDeLActiviteTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuUtilisateur boutonSupprimer = new menuUtilisateur();
                boutonSupprimer.show();
                dispose();
            }
        });
        nomDeLActiviteTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuUtilisateur boutonAjouter = new menuUtilisateur();
                boutonAjouter.show();
                dispose();
            }
        });
        validerButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuUtilisateur retourMenu = new menuUtilisateur();
                retourMenu.show();
                dispose();
            }
        });
        nomDuRobotATextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuUtilisateur retourMenu = new menuUtilisateur();
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
        nouveauEmailTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = nouveauEmailTextField.getText();
            }
        });
        numéroDeSérieTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = numéroDeSérieTextField1.getText();
            }
        });
        nomTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = nomTextField.getText();
            }
        });
        retourAuMenuUtilisateurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuUtilisateur retourMenu = new menuUtilisateur();
                retourMenu.show();
                dispose();
            }
        });
    }
}

