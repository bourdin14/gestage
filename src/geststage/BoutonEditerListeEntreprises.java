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
public class BoutonEditerListeEntreprises implements ActionListener {

    MySQLConnexion bdd;
    String[] entreprise = new String[7];
    String[] user;
    
    public BoutonEditerListeEntreprises(MySQLConnexion BDDConnexion, int ind, String[][] liste, String[] paramUser) {
        bdd = BDDConnexion;
        user = paramUser;
        for (int i=0; i<7; i++) {
            entreprise[i] = liste[i][ind];
        }
        
    }
    
    public void actionPerformed(ActionEvent e) {
        Fenetre.panelEntreprise(bdd, entreprise[0], user);
    }

}
