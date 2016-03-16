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
public class Descriptif extends JPanel {

    JLabel infoLibelle, infoDesc, infoDomaine, infoDate, infoDuree, infoChemin;
    JLabel titre, libelle, desc, domaine, date, duree, chemin;
    JButton postuler, retour;

    /* Affichage de l'accueil */
    public Descriptif(MySQLConnexion BDDConnexion, String[] offre, String[] user, boolean estPost) {
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setBackground(Color.orange);

        // Affichage du titre
        titre = new JLabel("Descriptif de l'offre");
        Font font = new Font("Arial", Font.PLAIN, 25);
        titre.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);
        add(titre, gbc);

        // Affichage du libelle
        infoLibelle = new JLabel("Titre");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        //add(infoLibelle, gbc);
        
        libelle = new JLabel(offre[1]);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(libelle, gbc);

        // Affichage de la description
        infoDesc = new JLabel("Description");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 10, 0, 0);
        //add(infoDesc, gbc);
        
        desc = new JLabel(offre[2]);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(desc, gbc);
        
        // Affichage du domaine
        infoDomaine = new JLabel("Domaine");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 10, 0, 0);
        //add(infoDomaine, gbc);
        
        domaine = new JLabel(offre[3]);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(domaine, gbc);

        // Affichage date du debut
        infoDate = new JLabel("Date de debut");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 10, 0, 0);
        //add(infoDate, gbc);
        
        date = new JLabel(offre[4]);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(date, gbc);

        // Affichage duree
        infoDuree = new JLabel("Duree");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 10, 0, 0);
        //add(infoDuree, gbc);
        
        duree = new JLabel(offre[5]);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(duree, gbc);
        
        // Affichage chemin
        infoChemin = new JLabel("Chemin");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 10, 0, 0);
        //add(infoChemin, gbc);
        
        chemin = new JLabel(offre[6]);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(chemin, gbc);
        
        // Boutons
        postuler = new JButton("Postuler");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 0, 10, 10);
        add(postuler, gbc);
        
        retour = new JButton("Retour");
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 0, 10, 10);
        add(retour, gbc);
        
        if (estPost) {
            // Si postulé
            postuler.setText("Retirer");
            System.out.println("Tableau Offre");
            for(int i=0; i<9; i++) {
                System.out.println(offre[i]);
            }
            postuler.addActionListener(new BoutonRetirerPost(BDDConnexion, offre, user));
            retour.addActionListener(new BoutonRetourPostul(BDDConnexion, user));
        } else {
            // Non postulé
            postuler.addActionListener(new BoutonPostuler(BDDConnexion, offre, user));
            retour.addActionListener(new BoutonRetourOffre(BDDConnexion, user));
        }
        
    }
}
