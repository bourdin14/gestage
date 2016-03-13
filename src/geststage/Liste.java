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
public class Liste extends JPanel {

    JLabel titre;
    JPanel espaceListe;
    JScrollPane espaceScroll;
    
    public Liste(boolean isAdmin, String typeListe, MySQLConnexion BDDConnexion) {
    
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.orange);

        if (isAdmin) {
            if (typeListe.equalsIgnoreCase("entreprise")) {
                // BDD select Entreprise
                /*int x;
                int y;
                String[][] liste = new String[4][];
                JButton[] boutonsSelect = new JButton[logExt.getNombreReservation()];
                liste = logExt.getlisteReservation();
                for (y=0; y<logExt.getNombreReservation(); y++) {
                        for (x=0; x<4; x++) {
                                gbc.insets = new Insets(5, 5, 5, 5);
                                gbc.gridx=x;
                        gbc.gridy=y+2;
                        add(new JLabel(liste[x][y]), gbc);
                        }
                        gbc.gridx=x;
                        gbc.gridy=y+2;

                        boutonsSelect[y] = new JButton("S\u00E9lectionner");
                        add(boutonsSelect[y], gbc);
                        boutonsSelect[y].addActionListener(new BoutonSelectionListeReservationListener(logExt, logInt, y, chambre));
                }
                 */
                // Affichage du titre
                titre = new JLabel("Liste Entreprise Admin");
                Font font = new Font("Arial", Font.PLAIN, 25);
                titre.setFont(font);
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 2;
                gbc.insets = new Insets(20, 20, 20, 20);
                add(titre, gbc);
                gbc.gridwidth = 1;
            } else {
                titre = new JLabel("Liste Offres Admin");
                Font font = new Font("Arial", Font.PLAIN, 25);
                titre.setFont(font);
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 2;
                gbc.insets = new Insets(20, 20, 20, 20);
                add(titre, gbc);
                gbc.gridwidth = 1;
            }
        } else {
            // Affiche Titre
            titre = new JLabel("Liste Offres etudiant");
            Font font = new Font("Arial", Font.PLAIN, 25);
            titre.setFont(font);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(20, 20, 20, 20);
            add(titre, gbc);
            gbc.gridwidth = 1;
                
            // Affiche la liste des offres
            espaceListe = new JPanel();
            espaceListe.setLayout(new GridBagLayout());
            GridBagConstraints gbcEspaceListe = new GridBagConstraints();
            espaceScroll = new JScrollPane(espaceListe);
            espaceScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
            espaceScroll.setPreferredSize(new Dimension(500, 250));
            
            // Affichage du bouton selectionner
            String[][] liste = new String[9][];
            JButton[] boutonsSelect = new JButton[BDDConnexion.getNombreOffres()];
            liste = BDDConnexion.getListeOffres();
            for (int i=0; i<BDDConnexion.getNombreOffres(); i++) {
                gbcEspaceListe.insets = new Insets(2, 2, 2, 2);
                
                gbcEspaceListe.gridx=0;
                gbcEspaceListe.gridy=i;
                espaceListe.add(new JLabel(liste[1][i]), gbcEspaceListe);

                gbcEspaceListe.gridx=1;
                gbcEspaceListe.gridy=i;
                boutonsSelect[i] = new JButton("S\u00E9lectionner");
                espaceListe.add(boutonsSelect[i], gbcEspaceListe);
                boutonsSelect[i].addActionListener(new BoutonSelectionListeOffres(BDDConnexion, i, liste));
            }
            
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(espaceScroll, gbc);
        }
    }
}
