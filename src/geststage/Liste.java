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
    
    public Liste(boolean isAdmin, String typeListe) {
    
        
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
            titre = new JLabel("Liste Offres etudiant");
                Font font = new Font("Arial", Font.PLAIN, 25);
                titre.setFont(font);
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 2;
                gbc.insets = new Insets(20, 20, 20, 20);
                add(titre, gbc);
                gbc.gridwidth = 1;
        }
    }
}
