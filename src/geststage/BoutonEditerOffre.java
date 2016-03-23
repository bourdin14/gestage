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
public class BoutonEditerOffre implements ActionListener {

    JTextField libelle, desc, domaine, date, duree, chemin;
    MySQLConnexion bdd;
    String id;
    String[] user;
    
    public BoutonEditerOffre(MySQLConnexion BDDConnexion, String paramId, JTextField champLibelle, JTextField champDesc, JTextField champDomaine, JTextField champDate, JTextField champDuree, JTextField champChemin, String[] paramUser) {
        id = paramId;
        libelle = champLibelle;
        desc = champDesc;
        domaine = champDomaine;
        date = champDate;
        duree = champDuree;
        chemin = champChemin;
        bdd = BDDConnexion;
        user = paramUser;
        zrgoi
    }
    
    public void actionPerformed(ActionEvent e) {
        String libelleString = libelle.getText();
    	String descString = desc.getText();
        String domaineString = domaine.getText();
        String dateString = date.getText();
        String telString = duree.getText();
        String cheminString = chemin.getText();
        
        if (libelleString.equals("") || descString.equals("") || cheminString.equals("") || dateString.equals("") || telString.equals("") || cheminString.equals("") ) {
            JOptionPane.showMessageDialog(null, "Tous les champs doivent \u00EAtre renseign\u00E9 !", "Erreur", JOptionPane.ERROR_MESSAGE); // j'affiche un popup.
        } else {
            bdd.updateEntreprise(id, libelleString, descString, cheminString, dateString, telString, cheminString);
            JOptionPane.showMessageDialog(null, "L'entreprise a bien \u00E9t\u00E9 mise à jour !", "Information", JOptionPane.INFORMATION_MESSAGE); // j'affiche un popup.
            Fenetre.panelListe(true, "offre", bdd, user);
        }
    }

}
