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
public class Admin extends JPanel {

    JButton listeEntr, listeOffr, listeDem, deconnexion;

    public Admin(MySQLConnexion BDDConnexion, String[] user) {

        setBackground(Color.orange);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        listeEntr = new JButton("Liste des entreprises");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 10);
        add(listeEntr, gbc);
        
        listeOffr = new JButton("Liste des offres");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 10);
        add(listeOffr, gbc);

        listeDem = new JButton("Consulter les demandes");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 10);
        add(listeDem, gbc);
        
        deconnexion = new JButton("Deconnexion");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 10);
        add(deconnexion, gbc);
        
        listeEntr.addActionListener(new BoutonListe(true, "entreprise", BDDConnexion, user));
        listeOffr.addActionListener(new BoutonListe(true, "offre", BDDConnexion, user));
        listeDem.addActionListener(new BoutonDem(BDDConnexion));
        deconnexion.addActionListener(new BoutonDeconnexion(BDDConnexion));
    }

}
