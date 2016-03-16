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
public class Post extends JPanel {

    JLabel titre;
    JPanel espaceListe;
    JScrollPane espaceScroll;
    JButton retour;

    public Post(MySQLConnexion BDDConnexion, String[] user) {
        
    
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.orange);

        // Affichage du titre
        titre = new JLabel("Mes postulation");
        Font font = new Font("Arial", Font.PLAIN, 25);
        titre.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);
        add(titre, gbc);
        gbc.gridwidth = 1;

        // Affiche la liste des postulations
        espaceListe = new JPanel();
        espaceListe.setLayout(new GridBagLayout());
        GridBagConstraints gbcEspaceListe = new GridBagConstraints();
        espaceScroll = new JScrollPane(espaceListe);
        espaceScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        espaceScroll.setPreferredSize(new Dimension(500, 250));
        
        String[][] liste = new String[2][];
        String[] offre = new String[2];
        JButton[] boutonsSelect = new JButton[BDDConnexion.getNombrePost(user[0])];
        liste = BDDConnexion.getPostulations(user[0]);
        
        for (int i=0; i<BDDConnexion.getNombrePost(user[0]); i++) {
            gbcEspaceListe.insets = new Insets(2, 2, 2, 2);
             
            gbcEspaceListe.gridx=0;
            gbcEspaceListe.gridy=i;
            espaceListe.add(new JLabel(liste[1][i]), gbcEspaceListe);

            gbcEspaceListe.gridx=1;
            gbcEspaceListe.gridy=i;
            boutonsSelect[i] = new JButton("Consulter");
            espaceListe.add(boutonsSelect[i], gbcEspaceListe);
            offre[0] = liste[0][i];
            offre[1] = liste[1][i];
            
            System.out.println("Offres en parametre :");
            System.out.println(offre[0]);
            System.out.println(offre[1]);
            boutonsSelect[i].addActionListener(new BoutonConsulterPost(BDDConnexion, offre, user, true));
        }        
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(espaceScroll, gbc);
        
        retour = new JButton("Retour");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 0, 10, 10);
        add(retour, gbc);
            
        retour.addActionListener(new BoutonRetourEtudiant(BDDConnexion, user));
    }
}
