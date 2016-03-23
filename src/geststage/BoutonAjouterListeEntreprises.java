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
public class BoutonAjouterListeEntreprises implements ActionListener {

    MySQLConnexion bdd;
    String[] user;
    
    public BoutonAjouterListeEntreprises(MySQLConnexion BDDConnexion, String[] paramUser) {
        bdd = BDDConnexion;
        user = paramUser;
    }
    
    public void actionPerformed(ActionEvent e) {
        Fenetre.panelEntreprise(bdd, "", user);
    }

}
