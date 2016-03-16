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
public class BoutonRetirerPost implements ActionListener {

    MySQLConnexion bdd;
    String[] offre, user;
    
    public BoutonRetirerPost(MySQLConnexion BDDConnexion, String[] paramOffre, String[] paramUser) {
        bdd = BDDConnexion;
        offre = paramOffre;
        user = paramUser;
    }
    
    public void actionPerformed(ActionEvent e) {
        System.out.println("id du stage à retirer : "+offre[0]);
        System.out.println("id de l'etu  : "+user[0]);
        bdd.delPostulation(offre[0], user[0]);
        Fenetre.panelPost(bdd, user);
    }

}
