package view;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;

import javax.swing.*;

import javax.swing.border.Border;

import model.Message;

public class IHM_Message extends JPanel{
    
    private JLabel msgLabel;
    private String msg="";

    
    public IHM_Message() {
        this.setPreferredSize(new Dimension(200, 300));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //bordure imaginaire
        Border c =  BorderFactory.createEmptyBorder(5,5,5,5);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        msg = "<html><p>Message :</p></html>";
        
        msgLabel = new JLabel();
        msgLabel.setText(msg);
        //msgLabel.setBorder(c);
        this.add(msgLabel);
        
        // Bordure
        Border b =  BorderFactory.createLineBorder(Color.black);
        this.setBorder(b);
    }
    
    public void refresh(Message ar) {
        /**
         * TODO : Completer
         */
        
        msg = "<html><p>Message :</p>" +
              "<p>"+ar.getMessage()+"</p></html>";

        msgLabel.setText(msg);

        
    }
}
