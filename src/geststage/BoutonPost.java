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
public class BoutonPost implements ActionListener {

    int id;
    public BoutonPost(int paramId) {
        id = paramId;
    }
    
    public void actionPerformed(ActionEvent e) {
        Fenetre.panelPost(id);
    }

}

