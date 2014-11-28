package view;

import controller.Game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * JTextArea qui va contenir la carte
 * @author Nicolas Nguyen
 */
@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class IHM_Board extends JTextArea{
    
    private         String          map;                            // String de la map
    private static  IHM_Board       uniqueInstance  =   null;       // Variable d'instance, pour le singleton
    
    /**
     * M�thode constructeur de la map. 
     * @param x : taille x de la map
     * @param y : taille y de la map
     */
    public IHM_Board(int x, int y) {       
        Font resultFont = new Font("monospaced", Font.PLAIN, 15);       // Font sp�cial, chaque caract�re est de la m�me taille, id�al pour un affichage
        Border b = BorderFactory.createLineBorder(Color.black);
        
        this.setColumns(x*4);
        this.setRows(y*4);
        this.setBorder(b);
        this.setEditable(false);  
        this.setCursor(null);  
        this.setFocusable(false);
        this.setFont(resultFont);
    }
    
    /**
     * M�thode utilis� pour int�gration du design pattern singleton
     * @return Instance IHM_Board
     */
    public static IHM_Board getInstance() {
        if (uniqueInstance == null) {
            try {
            uniqueInstance = new IHM_Board(Game.getInstance().getCurrentRoom().getTailleX(),Game.getInstance().getCurrentRoom().getTailleY());
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return uniqueInstance;
    }
    
    
    /**
     * Methode qui va refresh la board.
     */
    public void refresh() {
        map="";                                                 // Remise � 0 de la map
        char[][] table = Game.getInstance().getTab();           // R�cup�re le tableau de la map
        // Compteurs
        int j;                                                  // Variable compteur
        int k;                                                  // Variable compteur

            for (j=0; j<table.length; j++) {                    // Lit le tableau et le transforme en String
                for (k=0; k<table[0].length;k++) {
                    map+=table[j][k]+ "  ";
                }
                map+="\n";
            }
        this.setText(map);
    }
}
