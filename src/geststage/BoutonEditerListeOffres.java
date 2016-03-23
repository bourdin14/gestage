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
public class BoutonEditerListeOffres implements ActionListener {

    MySQLConnexion bdd;
    String[] offre = new String[9];
    String[] user;
    
    public BoutonEditerListeOffres(MySQLConnexion BDDConnexion, int ind, String[][] liste, String[] paramUser) {
        bdd = BDDConnexion;
        user = paramUser;
        for (int i=0; i<9; i++) {
            offre[i] = liste[i][ind];
        }
        
    }
    
    public void actionPerformed(ActionEvent e) {
        Fenetre.panelDescriptif(bdd, offre, user, true);
    }

}
