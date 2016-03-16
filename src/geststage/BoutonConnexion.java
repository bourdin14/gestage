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

    JTextField login, mdp;
    MySQLConnexion bdd;
    
    public BoutonConnexion(JTextField champLogin, JTextField champMdp, MySQLConnexion BDDConnexion) {
        login = champLogin;
        mdp = champMdp;
        BDDConnexion = new MySQLConnexion();
        bdd = BDDConnexion;
    }
    
    public void actionPerformed(ActionEvent e) {
        String loginString = login.getText();
    	String mdpString = mdp.getText();
        if(loginString.equals("") || mdpString.equals("")) { // Si l'un des deux champs est vide,
            JOptionPane.showMessageDialog(null, "Tous les champs doivent \u00EAtre renseign\u00E9 !!", "Erreur", JOptionPane.ERROR_MESSAGE); // j'affiche un popup.
        } else {
            bdd.requeteLogin(loginString, mdpString);
            String[] user;
            user = bdd.getResRequeteLogin();
            for (int i=0; i<4; i++) {
                System.out.println("user["+i+"] = "+user[i]);
            }
            if (user[0]==null) {
                JOptionPane.showMessageDialog(null, "Login ou mot de passe incorrect", "Information", JOptionPane.INFORMATION_MESSAGE); // j'affiche un popup.
            } else if (Integer.parseUnsignedInt(user[1])==0) {
                Fenetre.panelEtudiant(Integer.parseInt(user[0]), bdd, user);
            } else {
                Fenetre.panelAdmin(bdd, user);
            }
        }
    }

}
