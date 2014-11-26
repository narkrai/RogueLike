package view;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.Font;

import javax.swing.*;

import javax.swing.border.Border;

import model.Message;

/**
 * Partie de l'interface qui va indiquer à l'utilisateur ce qu'il s'est passé dans le jeu.
 * @author : Nicolas Nguyen
 */
public class IHM_Message extends JPanel{
    private     JTextArea       msgTextArea;    // JTextArea qui contient le message
    private     String          msg;            // String du message
    private static      IHM_Message      uniqueInstance = null;
    
    /**
     * Constructeur de l'IHM_Message
     */
    public IHM_Message() {
        this.setPreferredSize(new Dimension(100, 100));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        Border c =  BorderFactory.createEmptyBorder(5,5,5,5);   // Bordure imaginaire
        Font font = new Font("Arial", Font.BOLD, 12);           // Police utilisé par la JTextArea, pour match les autres parties de l'interface

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

    public void setEmpty() {
        this.msgTextArea.setText("Message : ");
    }

    public static IHM_Message getInstance()
    {
        if (uniqueInstance == null) 
        {
            try 
            {
            uniqueInstance = new IHM_Message();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        return uniqueInstance;
    }
    
    /**
     * Méthode qui va refresh le message
     * @param Message
     */
    public void refresh(Message ar) {
        msg = "Message :\n"+ar.getMessage();
        msgTextArea.setText(msg);
    }
}
