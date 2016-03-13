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
import java.sql.*;

class MySQLConnexion {

    private Statement declaration;
    private Connection connexion;
    String[] res = new String[4];

    /* Connexion a la base de donnee */
    public MySQLConnexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:8889/gestionstage?zeroDateTimeBehavior=convertToNull";
            String user = "root";
            String passwd = "root";
            this.connexion = DriverManager.getConnection(url, user, passwd);

            try {
                this.declaration = this.connexion.createStatement();
            } catch (SQLException e) {
                try {
                    this.connexion.close();
                } catch (SQLException e1) {
                }
                System.err.println("Declaration non etablie !");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.err.println("Connexion non etablie !");
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.err.println("Pilote MySQL introuvable !");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    /* Methode permettant de rechercher dans la BDD le login et le mot de passe */
    public void requeteLogin(String paramLogin, String paramMdp) {

        ResultSet rs = null;
        try {
            rs = declaration.executeQuery("SELECT * FROM user WHERE login = '" + paramLogin + "' AND password = '" + paramMdp+"'");
            while(rs.next()) {
                res[0] = rs.getString(1);
                res[1] = rs.getString(2);
                res[2] = rs.getString(3);
                res[3] = rs.getString(4);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Requete ou recuperation echouee !");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("OK 1");
    }
    
    public String[] getResRequeteLogin() {
        return res;
    }
    
    public int getNombreOffres() {
        ResultSet rs = null;
        int nbOffres=0;
        try {
            rs = declaration.executeQuery("SELECT id FROM stage WHERE valide=1");
            while(rs.next()) {
                nbOffres++;
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Requete ou recuperation echouee !");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return nbOffres;
    }
    
    public String[][] getListeOffres() {
        ResultSet rs = null;
        String[][] listeOffres = new String[9][];
        String[] id = new String[100];
        String[] libelle = new String[100];
        String[] description = new String[100];
        String[] domaine = new String[100];
        String[] dateDebut = new String[100];
        String[] duree = new String[100];
        String[] chemin = new String[100];
        String[] valide = new String[100];
        String[] id_entreprise = new String[100];
        try {
            rs = declaration.executeQuery("SELECT * FROM stage WHERE valide=1");
            for (int i=0; rs.next();i++) {
		id[i] = rs.getString(1);
		libelle[i] = rs.getString(2);
		description[i] = rs.getString(3);
		domaine[i] = rs.getString(4);
		dateDebut[i] = rs.getString(5);
		duree[i] = rs.getString(6);
		chemin[i] = rs.getString(7);
		valide[i] = rs.getString(8);
		id_entreprise[i] = rs.getString(9);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Requete ou recuperation echouee !");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        listeOffres[0] = id;
        listeOffres[1] = libelle;
        listeOffres[2] = description;
        listeOffres[3] = domaine;
        listeOffres[4] = dateDebut;
        listeOffres[5] = duree;
        listeOffres[6] = chemin;
        listeOffres[7] = valide;
        listeOffres[8] = id_entreprise;
        
        return listeOffres;
    }
    
    public void addPostulation() {
        
    }
}
