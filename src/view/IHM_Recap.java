package view;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;

public class IHM_Recap extends JPanel{
    
    String score;
    String monster = "<html><p>Monster : </p></html>";
    
    public IHM_Recap(int nbGold , int monsterKilled) {
        this.setPreferredSize(new Dimension(200, 400));
        
        score = "<html><p>Score :  "+ nbGold  +" gold</p></html>";
        monster = "<html><p>Monster : "+monsterKilled+" </p></html>";
        
        
        JLabel jLabelScore = new JLabel();
        jLabelScore.setText(score);
        jLabelScore.setPreferredSize(new Dimension(180, 120));
        this.add(jLabelScore);
        
        JLabel jLabelMonster = new JLabel();
        jLabelMonster.setText(monster);
        jLabelMonster.setPreferredSize(new Dimension(180, 120));
        this.add(jLabelMonster);
        
        // Bordure
        Border b =  BorderFactory.createLineBorder(Color.black);
        this.setBorder(b);
    }
    
}
