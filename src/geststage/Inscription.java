/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geststage;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author valentinbocquel
 */
public class Inscription extends JPanel {
    JLabel titre, login, mdp;
    static JTextField champLogin, champMdp;
    JButton valider;
    
    public Inscription(MySQLConnexion BDDConnexion) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setBackground(Color.orange);

        // Affichage du titre
        titre = new JLabel("S'inscrire");
        Font font = new Font("Arial", Font.PLAIN, 25);
        titre.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);
        add(titre, gbc);
        gbc.gridwidth = 1;

        // Affichage du formulaire
        login = new JLabel("Login");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(login, gbc);

        mdp = new JLabel("Mot de passe");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(mdp, gbc);

        champLogin = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 10);
        add(champLogin, gbc);

        champMdp = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 10, 0, 10);
        add(champMdp, gbc);

        valider = new JButton("S'inscrire");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 10);
        add(valider, gbc);

        valider.addActionListener(new BoutonValiderInsc(champLogin, champMdp, BDDConnexion));
    }
}
