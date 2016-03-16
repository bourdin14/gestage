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
public class BoutonListe implements ActionListener {

    String typeListe;
    String[] user;
    boolean isAdmin;
    MySQLConnexion bdd;
    
    public BoutonListe(boolean paramIsAdmin, String paramTypeListe, MySQLConnexion BDDConnexion, String[] paramUser) {
        typeListe = paramTypeListe;
        isAdmin = paramIsAdmin;
        bdd = BDDConnexion;
        user = paramUser;
    }
    
    public void actionPerformed(ActionEvent e) {
        Fenetre.panelListe(isAdmin, typeListe, bdd, user);
    }

}
