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
        
        // Message à afficher
        message= msg.getMessage()+" Test de la frame bla bla le lbe ble j'espre que ca depasse pas car j'ai mis des html tag lol";
        
        //bordure imaginaire
        Border c =  BorderFactory.createEmptyBorder(5,5,5,5);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JTextArea jTextAreaMessage = new JTextArea("Message :\n", 20,20);
        jTextAreaMessage.append(message);
        jTextAreaMessage.setBorder(c);
        jTextAreaMessage.setEditable(false);  
        jTextAreaMessage.setCursor(null);  
        jTextAreaMessage.setOpaque(false);  
        jTextAreaMessage.setFocusable(false);
        jTextAreaMessage.setLineWrap(true);
        jTextAreaMessage.setWrapStyleWord(true);

        this.add(jTextAreaMessage);
        
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
