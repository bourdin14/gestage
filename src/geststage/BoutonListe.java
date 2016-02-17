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
    boolean isAdmin;
    MySQLConnexion bdd;
    
    public BoutonListe(boolean paramIsAdmin, String paramTypeListe, MySQLConnexion BDDConnexion) {
        typeListe = paramTypeListe;
        isAdmin = paramIsAdmin;
        bdd = BDDConnexion;
    }
    
    public void actionPerformed(ActionEvent e) {
        Fenetre.panelListe(isAdmin, typeListe, bdd);
    }

}
