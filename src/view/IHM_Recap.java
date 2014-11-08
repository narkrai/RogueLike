package view;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;

import model.Message;

public class IHM_Recap extends JPanel{
    
    String gold;
    String monster;
    String message;
    
    public IHM_Recap(int nbGold , int monsterKilled, Message msg) {
        this.setPreferredSize(new Dimension(200, 600));
        
        gold = "<html><p>Gold :  "+ nbGold  +" gold</p></html>";
        monster = "<html><p>Monster : "+monsterKilled+" </p></html>";
        message = "<html><p> Recap : "+ msg.getMessage()+"</p></html>";
        
        JLabel jLabelScore = new JLabel();
        jLabelScore.setText(gold);
        jLabelScore.setPreferredSize(new Dimension(180, 120));
        this.add(jLabelScore);
        
        JLabel jLabelMonster = new JLabel();
        jLabelMonster.setText(monster);
        jLabelMonster.setPreferredSize(new Dimension(180, 120));
        this.add(jLabelMonster);
        
        JLabel jLabelMessage = new JLabel();
        jLabelMessage.setText(message);
        jLabelMessage.setPreferredSize(new Dimension(180, 120));
        this.add(jLabelMessage);
        
        // Bordure
        Border b =  BorderFactory.createLineBorder(Color.black);
        this.setBorder(b);
    }
    
    public void refresh() {
        
    }
    
}
