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
    public Object[] requeteLogin(String paramLogin, String paramMdp) {

        ResultSet rs = null;
        String login, mdp;
        int id, isAdmin;
        Object[] res = new Object[4];
       
        try {
            rs = declaration.executeQuery("SELECT * FROM user WHERE login = '" + paramLogin + "' AND password = '" + paramMdp+"'");
            res[0] = rs.getInt(1);
            res[1] = rs.getInt(2);
            res[2] = rs.getString(3);
            res[3] = rs.getString(4);   
            rs.close();
            System.out.println("Login : "+res[0]);
        } catch (SQLException e) {
            System.err.println("Requete ou recuperation echouee !");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        
        return res;
    }

}
