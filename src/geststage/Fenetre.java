/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geststage;

/**
 *
 * @author valentinbocquel
 */
import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    private static JLabel titre;
    private static JPanel content;
    private static CardLayout cardLayout;
    static JPanel[] panels = new JPanel[9];
    MySQLConnexion BDDConnexion = new MySQLConnexion();

    /* Creation de la fenetre et des CardLayout */
    public Fenetre() {

        // Intitule
        JPanel header = new JPanel();
        titre = new JLabel("Gestion de stage");
        Font font = new Font("Serif", Font.PLAIN, 36);
        titre.setFont(font);

        header.add(titre);
        header.setBackground(Color.orange);
        add(header, BorderLayout.NORTH);

        // CardLayout
        content = new JPanel(cardLayout = new CardLayout());
        panelLogin(BDDConnexion);
        add(content, BorderLayout.CENTER);
    }

    /* */
    public static void panelLogin(MySQLConnexion BDDConnexion) {
        panels[0] = new Login(BDDConnexion);
        content.add(panels[0], "Login");
        cardLayout.show(content, "Login");
    }
    
    public static void panelAdmin(MySQLConnexion BDDConnexion) {
        panels[1] = new Admin(BDDConnexion);
        content.add(panels[1], "Admin");
        cardLayout.show(content, "Admin");
    }
    
    public static void panelListe(boolean isAdmin, String typeListe, MySQLConnexion BDDConnexion) {
        panels[2] = new Liste(isAdmin, typeListe, BDDConnexion);
        content.add(panels[2], "Liste");
        cardLayout.show(content, "Liste");
    }
    
    public static void panelDemande(MySQLConnexion BDDConnexion) {
        panels[3] = new Demande(BDDConnexion);
        content.add(panels[3], "Demande");
        cardLayout.show(content, "Demande");
    }
    
    public static void panelEtudiant(int id, MySQLConnexion BDDConnexion) {
        panels[4] = new Etudiant(id, BDDConnexion);
        content.add(panels[4], "Etudiant");
        cardLayout.show(content, "Etudiant");
    }
    
    public static void panelPost(int id, MySQLConnexion BDDConnexion) {
        panels[5] = new Post(id, BDDConnexion);
        content.add(panels[5], "Post");
        cardLayout.show(content, "Post");
    }
    
    public static void panelInscription(MySQLConnexion BDDConnexion) {
        panels[6] = new Inscription(BDDConnexion);
        content.add(panels[6], "Inscription");
        cardLayout.show(content, "Inscription");
    }
    
    public static void panelDescriptif(MySQLConnexion BDDConnexion, String[] offre) {
        panels[7] = new Descriptif(BDDConnexion, offre);
        content.add(panels[7], "Descriptif");
        cardLayout.show(content, "Descriptif");
    }
   
}
