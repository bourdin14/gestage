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
public class Etudiant extends JPanel {

    JButton listePost, listeOffr;

    public Etudiant(int id, MySQLConnexion BDDConnexion) {

        setBackground(Color.orange);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        listeOffr = new JButton("Consulter les offres");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 10);
        add(listeOffr, gbc);
        
        listePost = new JButton("Consulter mes postulations");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 10);
        add(listePost, gbc);
        
        listeOffr.addActionListener(new BoutonListe(false, "offre", BDDConnexion));
        listePost.addActionListener(new BoutonPost(id, BDDConnexion));
    }

}
