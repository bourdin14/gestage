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
public class BoutonConnexion implements ActionListener {

    String login, mdp;
    MySQLConnexion bdd;
    Object[] user;
    
    public BoutonConnexion(JTextField champLogin, JTextField champMdp, MySQLConnexion BDDConnexion) {
        login = champLogin.getText();
        mdp = champMdp.getText();
        bdd = BDDConnexion;
    }
    
    public void actionPerformed(ActionEvent e) {
        user = bdd.requeteLogin(login, mdp);
        Fenetre.panelEtudiant((Integer)user[0], bdd);
        //Fenetre.panelAdmin();
    }

}
