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
public class BoutonConsulterPost implements ActionListener {

    MySQLConnexion bdd;
    String[] offre, user;
    boolean estPost;
    
    public BoutonConsulterPost(MySQLConnexion BDDConnexion, String[] paramOffre, String[] paramUser, boolean paramEstPost) {
        bdd = BDDConnexion;
        offre = paramOffre;
        user = paramUser;
        estPost = paramEstPost;
    }
    
    public void actionPerformed(ActionEvent e) {
        offre = bdd.getOffre(offre[0]);
        Fenetre.panelDescriptif(bdd, offre, user, estPost);
    }

}
