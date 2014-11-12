package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;

public class IHM_Board extends JTextArea{
    
    private String board;
    private static IHM_Board uniqueInstance = null;
    
    public static IHM_Board getInstance()
    {
        if (uniqueInstance == null) 
        {
            try 
            {
            uniqueInstance = new IHM_Board();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        return uniqueInstance;
    }
    
    public IHM_Board(int x, int y) {       
        //this.setSize(new Dimension(500,500));
        Border b = BorderFactory.createLineBorder(Color.black);
        this.setColumns(x);
        this.setRows(y);
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
        
        for (i=0; i<table.length;i++){
            for (j=0; j<table[0].length; j++) {
                for (k=0; k<table[1].length;k++) {
                    board+=table[i][j]+" ";
                }
            }
        }
    }
}
