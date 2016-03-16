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
public class BoutonSelectionListeOffres implements ActionListener {

    MySQLConnexion bdd;
    int ind;
    String [][] liste;
    String[] offre = new String[9];
    String[] user;
    
    public BoutonSelectionListeOffres(MySQLConnexion BDDConnexion, int paramInd, String[][] paramListe, String[] paramUser) {
        bdd = BDDConnexion;
        ind = paramInd;
        liste = paramListe;
        user = paramUser;
    }
    
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<9; i++) {
            offre[i] = liste[i][ind];
        }
        Fenetre.panelDescriptif(bdd, offre, user, false);
    }

}
