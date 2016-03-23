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
public class BoutonAjouterEntreprise implements ActionListener {

    JTextField nom, raison, ville, code, telephone, domaine;
    MySQLConnexion bdd;
    String[] user;
    String id;
    
    public BoutonAjouterEntreprise(MySQLConnexion BDDConnexion, JTextField champNom, JTextField champRaison, JTextField champVille, JTextField champCode, JTextField champTel, JTextField champDomaine, String[] paramUser) {
        nom = champNom;
        raison = champRaison;
        ville = champVille;
        code = champCode;
        telephone = champTel;
        domaine = champDomaine;
        bdd = BDDConnexion;
        user = paramUser;
    }
    
    public void actionPerformed(ActionEvent e) {
        String nomString = nom.getText();
    	String raisonString = raison.getText();
        String villeString = ville.getText();
        String codeString = code.getText();
        String telString = telephone.getText();
        String domaineString = domaine.getText();
        
        if (nomString.equals("") || raisonString.equals("") || villeString.equals("") || codeString.equals("") || telString.equals("") || domaineString.equals("") ) {
            JOptionPane.showMessageDialog(null, "Tous les champs doivent \u00EAtre renseign\u00E9 !", "Erreur", JOptionPane.ERROR_MESSAGE); // j'affiche un popup.
        } else {
            bdd.addEntreprise(nomString, raisonString, villeString, codeString, telString, domaineString);
            JOptionPane.showMessageDialog(null, "L'entreprise a bien \u00E9t\u00E9 ajout\u00E9 !", "Information", JOptionPane.INFORMATION_MESSAGE); // j'affiche un popup.
            Fenetre.panelListe(true, "entreprise", bdd, user);
        }
    }

}
