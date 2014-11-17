package view;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.Font;

import javax.swing.*;

import javax.swing.border.Border;

import model.Message;

public class IHM_Message extends JPanel{
    
    private JTextArea msgTextArea;
    private String msg="";

    
    public IHM_Message() {
        this.setPreferredSize(new Dimension(100, 100));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //bordure imaginaire
        Border c =  BorderFactory.createEmptyBorder(5,5,5,5);
        Font font = new Font("Arial", Font.BOLD, 12);

        msg = "Message :";
        
        msgTextArea = new JTextArea();
        msgTextArea.setColumns(17);
        msgTextArea.setRows(12);
        msgTextArea.setWrapStyleWord(true);
        msgTextArea.setLineWrap(true);
        msgTextArea.setEditable(false);  
        msgTextArea.setCursor(null);  
        msgTextArea.setOpaque(false);  
        msgTextArea.setFocusable(false);
        msgTextArea.setFont(font);
        msgTextArea.setText(msg);
        
        this.add(msgTextArea);
        
        // Bordure
        Border b =  BorderFactory.createLineBorder(Color.black);
        this.setBorder(b);
    }
    
    public void refresh(Message ar) {

        msg = "Message :\n"+ar.getMessage();

        msgTextArea.setText(msg);

        
    }
}
