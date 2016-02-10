/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geststage;

import javax.swing.JFrame;

/**
 *
 * @author valentinbocquel
 */
public class GestStage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fenetre fen = new Fenetre();
	  fen.setTitle("Application de gestion de stages");
	  fen.setSize(800, 800);
	  fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  fen.setLocationRelativeTo(null);
	  fen.setVisible(true);
    }
    
}
