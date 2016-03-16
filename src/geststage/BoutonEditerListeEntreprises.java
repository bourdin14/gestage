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
    int ind;
    
    public BoutonEditerListeEntreprises(MySQLConnexion BDDConnexion, int paramInd, String[][] liste) {
        bdd = BDDConnexion;
        for (int i=0; i<7; i++) {
            entreprise[i] = liste[i][ind];
        }
        
    }
    
    public void actionPerformed(ActionEvent e) {
        Fenetre.panelEntreprise(bdd, entreprise[0]);
    }

}
