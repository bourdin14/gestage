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
public class BoutonValiderInsc implements ActionListener {

    String login, mdp;
    
    public BoutonValiderInsc(JTextField champLogin, JTextField champMdp) {
        login = champLogin.getText();
        mdp = champMdp.getText();
    }
    
    public void actionPerformed(ActionEvent e) {
        // Insert BDD

    }

}
