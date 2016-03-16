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
    JButton retour, ajouter;
    
    public Liste(boolean isAdmin, String typeListe, MySQLConnexion BDDConnexion, String[] user) {
    
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.orange);

        if (isAdmin) {
            if (typeListe.equalsIgnoreCase("entreprise")) {
                
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
                
                // Affiche la liste des entreprises
                espaceListe = new JPanel();
                espaceListe.setLayout(new GridBagLayout());
                GridBagConstraints gbcEspaceListe = new GridBagConstraints();
                espaceScroll = new JScrollPane(espaceListe);
                espaceScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
                espaceScroll.setPreferredSize(new Dimension(500, 250));

                // Affichage du bouton selectionner
                String[][] liste = new String[7][];
                JButton[] boutonsEdit = new JButton[BDDConnexion.getNombreEntreprises()];
                JButton[] boutonsSuppr = new JButton[BDDConnexion.getNombreEntreprises()];
                liste = BDDConnexion.getListeEntreprises();
                for (int i=0; i<BDDConnexion.getNombreEntreprises(); i++) {
                    gbcEspaceListe.insets = new Insets(2, 2, 2, 2);
                    gbcEspaceListe.gridx=0;
                    gbcEspaceListe.gridy=i;
                    espaceListe.add(new JLabel(liste[6][i]), gbcEspaceListe);
                    
                    gbcEspaceListe.gridx=1;
                    gbcEspaceListe.gridy=i;
                    boutonsEdit[i] = new JButton("Editer");
                    espaceListe.add(boutonsEdit[i], gbcEspaceListe);
                    
                    gbcEspaceListe.gridx=2;
                    gbcEspaceListe.gridy=i;
                    boutonsSuppr[i] = new JButton("Supprimer");
                    espaceListe.add(boutonsSuppr[i], gbcEspaceListe);
                    
                    boutonsEdit[i].addActionListener(new BoutonEditerListeEntreprises(BDDConnexion, i, liste));
                    boutonsSuppr[i].addActionListener(new BoutonSupprListeEntreprises(BDDConnexion, i, liste, user));                       
                }
                
                gbc.gridx = 0;
                gbc.gridy = 1;
                add(espaceScroll, gbc);
                
                ajouter = new JButton("Ajouter");
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.weightx = 0;
                gbc.gridwidth = 1;
                gbc.insets = new Insets(5, 0, 10, 10);
                add(ajouter, gbc);
                ajouter.addActionListener(new BoutonAjouterListeEntreprises(BDDConnexion));
                
                retour = new JButton("Retour");
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.weightx = 0;
                gbc.gridwidth = 1;
                gbc.insets = new Insets(5, 0, 10, 10);
                add(retour, gbc);
                
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
            JButton[] boutonsSelect = new JButton[BDDConnexion.getNombreOffres(user)];
            liste = BDDConnexion.getListeOffres(user);
            for (int i=0; i<BDDConnexion.getNombreOffres(user); i++) {
                gbcEspaceListe.insets = new Insets(2, 2, 2, 2);
                
                gbcEspaceListe.gridx=0;
                gbcEspaceListe.gridy=i;
                espaceListe.add(new JLabel(liste[1][i]), gbcEspaceListe);

                gbcEspaceListe.gridx=1;
                gbcEspaceListe.gridy=i;
                boutonsSelect[i] = new JButton("S\u00E9lectionner");
                espaceListe.add(boutonsSelect[i], gbcEspaceListe);
                boutonsSelect[i].addActionListener(new BoutonSelectionListeOffres(BDDConnexion, i, liste, user));
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
}
