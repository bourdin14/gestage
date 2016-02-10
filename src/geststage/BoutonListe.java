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
    
    public BoutonListe(boolean paramIsAdmin, String paramTypeListe) {
        typeListe = paramTypeListe;
        isAdmin = paramIsAdmin;
    }
    
    public void actionPerformed(ActionEvent e) {
        Fenetre.panelListe(isAdmin, typeListe);
    }

}
