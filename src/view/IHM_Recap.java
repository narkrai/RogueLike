package view;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;

import model.Message;

public class IHM_Recap extends JPanel{
    
    private String strength;
    private String gold;
    private String level;
    private String monster;
    
    private JLabel jLabelGold;
    private JLabel jLabelLevel;
    private JLabel jLabelMonster;
    
    public IHM_Recap(int nbGold , int monstersNearby, int lvl) {
        this.setPreferredSize(new Dimension(200, 300));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        gold = "<html><p>Gold :  "+ nbGold  +" gold</p></html>";
        level = "<html><p>Current level : " +lvl+ "</p></html>";
        monster = "<html><p>Monsters nearby : " + monstersNearby + "</p></html>";
        
        // Bordure imaginaire
        Border c =  BorderFactory.createEmptyBorder(5,5,60,5);
        
        JPanel goldPanel = new JPanel();
        goldPanel.setSize(new Dimension(200, 200));
        goldPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        jLabelGold = new JLabel();
        jLabelGold.setText(gold);
        jLabelGold.setBorder(c);
        goldPanel.add(jLabelGold);
        
        
        JPanel levelPanel = new JPanel();
        levelPanel.setSize(new Dimension(200, 200));
        levelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        jLabelLevel = new JLabel();
        jLabelLevel.setText(level);
        jLabelLevel.setBorder(c);
        levelPanel.add(jLabelLevel);
        
        JPanel monsterPanel = new JPanel();
        monsterPanel.setSize(new Dimension(200, 200));
        monsterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        jLabelMonster = new JLabel();
        jLabelMonster.setText(monster);
        jLabelMonster.setBorder(c);
        monsterPanel.add(jLabelMonster);
        
        
        this.add(jLabelGold);
        this.add(jLabelLevel);
        this.add(jLabelMonster);
        
        
        /*
        JLabel jLabelScore = new JLabel();
        jLabelScore.setText(gold);
        //jLabelScore.setPreferredSize(new Dimension(180, 120));
        this.add(jLabelScore);
        
        JLabel jLabelLevel = new JLabel();
        jLabelLevel.setText(level);
        //jLabelLevel.setPreferredSize(new Dimension(180, 120));
        this.add(jLabelLevel);
        
        JLabel jLabelMonster = new JLabel();
        jLabelMonster.setText(monster);
        //jLabelMonster.setPreferredSize(new Dimension(180, 120));
        this.add(jLabelMonster);*/

        // Bordure
        Border b =  BorderFactory.createLineBorder(Color.black);
        
        
        this.setBorder(b);
        
    }
    
    public void refresh() {
        
    }
    
}
