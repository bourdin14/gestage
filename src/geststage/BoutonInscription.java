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
public class BoutonInscription implements ActionListener {
    
    public BoutonInscription() {
    }
    
    public void actionPerformed(ActionEvent e) {
        Fenetre.panelInscription();
    }

}
