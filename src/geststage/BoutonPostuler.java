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
public class BoutonPostuler implements ActionListener {

    MySQLConnexion bdd;
    String[] offre, user;
    
    public BoutonPostuler(MySQLConnexion BDDConnexion, String[] paramOffre, String[] paramUser) {
        bdd = BDDConnexion;
        offre = paramOffre;
        user = paramUser;
    }
    
    public void actionPerformed(ActionEvent e) {
        bdd.addPostulation(offre, user);
        JOptionPane.showMessageDialog(null, "Votre postulation a bien \u00E9t\u00E9 prise en compte", "Information", JOptionPane.INFORMATION_MESSAGE); // j'affiche un popup.
        Fenetre.panelListe(false, "Liste Offres etudiant", bdd, user);
    }

}
