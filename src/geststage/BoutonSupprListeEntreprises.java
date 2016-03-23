/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geststage;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author valentinbocquel
 */
public class BoutonSupprListeEntreprises implements ActionListener {

    MySQLConnexion bdd;
    String[] entreprise = new String[7];
    String[] user;
    int choix;
    
    public BoutonSupprListeEntreprises(MySQLConnexion BDDConnexion, int ind, String[][] liste, String[] paramUser) {
        bdd = BDDConnexion;
        user = paramUser;
        for (int i=0; i<7; i++) {
            entreprise[i] = liste[i][ind];
        }
        
    }
    
    public void actionPerformed(ActionEvent e) {
        choix = JOptionPane.showConfirmDialog(null, "\u00EAtes vous sur de vouloir supprimer cette entreprise ?"); // j'affiche un popup.
        if (choix==0) {
            bdd.deleteEntreprise(entreprise[0]);
            JOptionPane.showMessageDialog(null, "L'entreprise a bien \u00E9t\u00E9 supprim\u00E9 !", "Information", JOptionPane.INFORMATION_MESSAGE); // j'affiche un popup.
            Fenetre.panelListe(true, "entreprise", bdd, user);
        }
    }

}
