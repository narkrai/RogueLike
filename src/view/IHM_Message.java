package view;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;

import javax.swing.*;

import javax.swing.border.Border;

import model.Message;

public class IHM_Message extends JPanel{
    
    private String message;
    
    public IHM_Message(Message msg) {
        
        message = "<html><p> Message : "+ msg.getMessage()+"</p></html>";
        //bordure imaginaire
        Border c =  BorderFactory.createEmptyBorder(5,5,60,5);
        
        this.setPreferredSize(new Dimension(200, 200));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel jLabelMessage = new JLabel();
        jLabelMessage.setBorder(c);
        jLabelMessage.setText(message);
        this.add(jLabelMessage);
        
        // Bordure
        Border b =  BorderFactory.createLineBorder(Color.black);
        this.setBorder(b);
    }
    
    public IHM_Message() {
        super();
    }
    
    public void refresh() {
        
    }
}
