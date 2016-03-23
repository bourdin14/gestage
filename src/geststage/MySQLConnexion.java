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
    }
    
    public String[] getResRequeteLogin() {
        return res;
    }
    
    public int getNombreOffres(String[] user) {
        ResultSet rs = null;
        int nbOffres=0;
        try {
            rs = declaration.executeQuery("SELECT * FROM stage WHERE valide=1 AND id NOT IN (SELECT id_stage FROM postulation WHERE id_etudiant="+user[0]+")");
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

    public int getNombrePost(String idEtu) {
        ResultSet rs = null;
        int nbPost=0;
        try {
            rs = declaration.executeQuery("SELECT id FROM postulation WHERE id_etudiant="+idEtu);
            while(rs.next()) {
                nbPost++;
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Requete ou recuperation echouee !");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return nbPost;
    }
    
    public String[] getOffre(String id) {
        ResultSet rs = null;
        String[] offre = new String[9];
        try {
            rs = declaration.executeQuery("SELECT * FROM stage WHERE id="+id);
            for (int i=0; rs.next();i++) {
		offre[0] = rs.getString(1);
		offre[1] = rs.getString(2);
		offre[2] = rs.getString(3);
		offre[3] = rs.getString(4);
		offre[4] = rs.getString(5);
		offre[5] = rs.getString(6);
		offre[6] = rs.getString(7);
		offre[7] = rs.getString(8);
		offre[8] = rs.getString(9);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Requete ou recuperation echouee !");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return offre;
    }
    
    
    public String[][] getListeOffres(String[] user) {
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
            rs = declaration.executeQuery("SELECT * FROM stage WHERE valide=1 AND id NOT IN (SELECT id_stage FROM postulation WHERE id_etudiant="+user[0]+")");
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
    
    public void addPostulation(String[] offre, String[] user) {
	try {
            declaration.executeUpdate("INSERT INTO postulation(id_etudiant, id_stage, validé)" + "VALUES ('"+user[0]+"', '"+offre[0]+"', 0)");
	} catch (SQLException e) {
            System.err.println("Echec de l'insertion dans postulation !");
            System.exit(1);
	}
    }

    public void delPostulation(String idStage, String idEtu) {
	try {
            declaration.executeUpdate("DELETE FROM postulation WHERE id_stage='"+idStage+"'"
                                    + " AND id_etudiant='"+idEtu+"'");
	} catch (SQLException e) {
            System.err.println("Echec de la suppression dans postulation !");
            System.exit(1);
	}
    }
    
    public String[][] getPostulations(String idUser) {
        ResultSet rs = null;
        String[] idPost = new String[100];
        String[] libelle = new String[100];
        String[][] listePost = new String[2][];
        try {
            rs = declaration.executeQuery("SELECT stage.id, stage.libelle "
                                        + "FROM postulation, stage "
                                        + "WHERE stage.id=postulation.id_stage "
                                        + "AND id_etudiant="+idUser);
            for (int i=0; rs.next();i++) {
		idPost[i] = rs.getString(1);
		libelle[i] = rs.getString(2);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Requete ou recuperation echouee !");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        listePost[0] = idPost;
        listePost[1] = libelle;
        
        return listePost;
    }
    
    public String[][] getListeEntreprises() {
        ResultSet rs = null;
        String[][] liste = new String[7][];
        
        String[] id = new String[100];
        String[] raisonSociale = new String[100];
        String[] ville = new String[100];
        String[] codePostal = new String[100];
        String[] telephone = new String[100];
        String[] domaine = new String[100];
        String[] nom = new String[100];
        try {
            rs = declaration.executeQuery("SELECT * FROM entreprise");
            for (int i=0; rs.next();i++) {
		id[i] = rs.getString(1);
		raisonSociale[i] = rs.getString(2);
		ville[i] = rs.getString(3);
		codePostal[i] = rs.getString(4);
		telephone[i] = rs.getString(5);
		domaine[i] = rs.getString(6);
		nom[i] = rs.getString(7);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Requete ou recuperation liste echouee !");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        liste[0] = id;
        liste[1] = raisonSociale;
        liste[2] = ville;
        liste[3] = codePostal;
        liste[4] = telephone;
        liste[5] = domaine;
        liste[6] = nom;
        
        return liste;
    }
    
    public int getNombreEntreprises() {
        ResultSet rs = null;
        int nbEntreprises=0;
        try {
            rs = declaration.executeQuery("SELECT * FROM entreprise");
            while(rs.next()) {
                nbEntreprises++;
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Requete ou recuperation nombre echouee !");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return nbEntreprises;
    }
    
    public String[] getEntreprise(String id) {
        ResultSet rs = null;
        String[] entreprise = new String[7];
        try {
            rs = declaration.executeQuery("SELECT * FROM entreprise WHERE id="+id);
            while(rs.next()) {
               for (int i=0; i<7; i++) {
                   entreprise[i] = rs.getString(i+1);
               }
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Requete ou recuperation nombre echouee !");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return entreprise;
    }
    
    public void addEntreprise(String nom, String raison, String ville, String code, String telephone, String domaine) {
	try {
            declaration.executeUpdate("INSERT INTO entreprise(raisonSociale, ville, codePostal, telephone, domaine, nom)"
                                    + " VALUES ('"+raison+"', '"+ville+"', '"+code+"', '"+telephone+"', '"+domaine+"', '"+nom+"')");
	} catch (SQLException e) {
            System.err.println("Echec de l'insertion dans entreprise !");
            System.exit(1);
	}
    }

    public void updateEntreprise(String id, String nom, String raison, String ville, String code, String telephone, String domaine) {
	try {
            declaration.executeUpdate("UPDATE entreprise SET raisonSociale='"+raison+"', ville='"+ville+"', codePostal='"+code+"', telephone='"+telephone+"', domaine='"+domaine+"', nom='"+nom+"'"
                                        + "WHERE id='"+id+"'");
	} catch (SQLException e) {
            System.err.println("Echec de la mise a jour de l'entreprise !");
            System.exit(1);
	}
    }

    public void deleteEntreprise(String id) {
	try {
            declaration.executeUpdate("DELETE FROM entreprise WHERE id='"+id+"'");
	} catch (SQLException e) {
            System.err.println("Echec de la suppression de l'entreprise !");
            System.exit(1);
	}
    }

}
