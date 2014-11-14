package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;

public class IHM_Board extends JTextArea{
    
    private String board;
    
   
    public IHM_Board(int x, int y) {       
        //this.setSize(new Dimension(500,500));
        Border b = BorderFactory.createLineBorder(Color.black);
        this.setColumns(x*2);
        this.setRows(y*2);
        this.setBorder(b);
        this.setEditable(false);  
        this.setCursor(null);  
        this.setFocusable(false);
    }
    
    // Fonction qui va refresh la board à chaque action
    public void refresh() {
        //Table
        board="";
        char[][] table = Game.getInstance().getTab();
        // Compteurs
        int i,j,k;
        
        
            for (j=0; j<table.length; j++) {
                for (k=0; k<table[0].length;k++) {
                    board+=table[j][k]+ " ";
                    System.out.println(" da"+ table[j][k]);
                }
                board+="\n";
            }
        
        
        this.setText(board);
    }
}
