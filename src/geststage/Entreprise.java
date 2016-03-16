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
public class Entreprise extends JPanel {

    JLabel titre, infoNom, infoRaison, infoDomaine, infoVille, infoCode, infoTelephone;
    JTextField nom, raison, domaine, ville, code, telephone;
    JButton postuler, retour;

    /* Affichage de l'accueil */
    public Entreprise(MySQLConnexion BDDConnexion, String id) {
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.orange);
        
        if (id.equals("")) {
            // champTexte Vide
        } else {
            String[] entreprise = BDDConnexion.getEntreprise(id);

            // Affichage du titre
            titre = new JLabel("Descriptif de l'entreprise");
            Font font = new Font("Arial", Font.PLAIN, 25);
            titre.setFont(font);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(20, 20, 20, 20);
            add(titre, gbc);

            // Affichage du libelle
            infoNom = new JLabel("Nom");
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 10, 0, 0);
            //add(infoLibelle, gbc);

            nom = new JTextField(entreprise[6]);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 10, 0, 0);
            add(nom, gbc);

            // Affichage de la description
            infoRaison = new JLabel("Raison");
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.insets = new Insets(0, 10, 0, 0);
            //add(infoDesc, gbc);

            raison = new JTextField(entreprise[1]);
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.insets = new Insets(0, 10, 0, 0);
            add(raison, gbc);

            // Affichage du domaine
            infoVille = new JLabel("Ville");
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.insets = new Insets(0, 10, 0, 0);
            //add(infoDomaine, gbc);

            ville = new JTextField(entreprise[2]);
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.insets = new Insets(0, 10, 0, 0);
            add(ville, gbc);

            // Affichage date du debut
            infoCode = new JLabel("Code postal");
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.insets = new Insets(0, 10, 0, 0);
            //add(infoDate, gbc);

            code = new JTextField(entreprise[3]);
            gbc.gridx = 1;
            gbc.gridy = 4;
            gbc.insets = new Insets(0, 10, 0, 0);
            add(code, gbc);

            // Affichage duree
            infoTelephone = new JLabel("Telephone");
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.insets = new Insets(0, 10, 0, 0);
            //add(infoDuree, gbc);

            telephone = new JTextField(entreprise[4]);
            gbc.gridx = 1;
            gbc.gridy = 5;
            gbc.insets = new Insets(0, 10, 0, 0);
            add(telephone, gbc);

            // Affichage chemin
            infoDomaine = new JLabel("Domaine");
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.insets = new Insets(0, 10, 0, 0);
            //add(infoChemin, gbc);

            domaine = new JTextField(entreprise[5]);
            gbc.gridx = 1;
            gbc.gridy = 6;
            gbc.insets = new Insets(0, 10, 0, 0);
            add(domaine, gbc);

            // Boutons
            postuler = new JButton("Postuler");
            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.weightx = 0;
            gbc.gridwidth = 1;
            gbc.insets = new Insets(5, 0, 10, 10);
            add(postuler, gbc);
        }

            retour = new JButton("Retour");
            gbc.gridx = 1;
            gbc.gridy = 7;
            gbc.weightx = 0;
            gbc.gridwidth = 1;
            gbc.insets = new Insets(5, 0, 10, 10);
            add(retour, gbc);
        
    }
}
