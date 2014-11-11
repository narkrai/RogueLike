package view;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;

public class IHM_Board extends JTextArea{
    public IHM_Board(int x, int y) {

        this.setSize(new Dimension(500,500));
        Border b = BorderFactory.createLineBorder(Color.black);
        this.setColumns(x);
        this.setRows(y);
        this.setBorder(b);
        
        this.setEditable(false);  
        this.setCursor(null);  
        this.setFocusable(false);
    }
}
