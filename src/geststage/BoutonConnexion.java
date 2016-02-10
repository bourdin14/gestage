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
    
    public BoutonConnexion(JTextField champLogin, JTextField champMdp) {
        login = champLogin.getText();
        mdp = champMdp.getText();
    }
    
    public void actionPerformed(ActionEvent e) {
        // verification BDD
        int id = 5;
        Fenetre.panelEtudiant(id);
        //Fenetre.panelAdmin();
    }

}
