package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;



public class IHM_Board extends JTextArea{
    
    private String map;
    
    public IHM_Board(int x, int y) {       
        Font resultFont = new Font("monospaced", Font.PLAIN, 15);
        Border b = BorderFactory.createLineBorder(Color.black);
        
        this.setColumns(x*2);
        this.setRows(y*2);
        this.setBorder(b);
        this.setEditable(false);  
        this.setCursor(null);  
        this.setFocusable(false);
        this.setFont(resultFont);
    }
    
    // Fonction qui va refresh la board à chaque action
    public void refresh() {
        //Table
        map="";
        char[][] table = Game.getInstance().getTab();
        // Compteurs
        int i,j,k;

            for (j=0; j<table.length; j++) {
                for (k=0; k<table[0].length;k++) {
                    map+=table[j][k]+ " ";
                    System.out.println(" da"+ table[j][k]);
                }
                map+="\n";
            }

        this.setText(map);
    }
}
