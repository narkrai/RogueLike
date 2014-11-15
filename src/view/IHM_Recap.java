package view;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;

import model.Message;

public class IHM_Recap extends JPanel{
    
    private JLabel strengthLabel;
    private JLabel goldLabel;
    private JLabel levelLabel;
    private JLabel monsterLabel;
    
    private String strength="";
    private String gold="";
    private String level="";
    private String monster="";

    
    public IHM_Recap() {
        this.setPreferredSize(new Dimension(200, 300));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Border c =  BorderFactory.createEmptyBorder(5,5,30,5);
        
        strength = "<html><p>Strength :</p></html>";
        gold = "<html><p>Gold : gold</p></html>";
        level = "<html><p>Current level : </p></html>";
        monster = "<html><p>Monsters nearby : </p></html>";
        
        JPanel strengthPanel = new JPanel();
        strengthPanel.setSize(new Dimension(200, 200));
        strengthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        strengthLabel = new JLabel();
        strengthLabel.setText(strength);
        strengthLabel.setBorder(c);
        strengthPanel.add(strengthLabel);
        
        JPanel goldPanel = new JPanel();
        goldPanel.setSize(new Dimension(200, 200));
        goldPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        goldLabel = new JLabel();
        goldLabel.setText(gold);
        goldLabel.setBorder(c);
        goldPanel.add(goldLabel);
        
        
        JPanel levelPanel = new JPanel();
        levelPanel.setSize(new Dimension(200, 200));
        levelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        levelLabel = new JLabel();
        levelLabel.setText(level);
        levelLabel.setBorder(c);
        levelPanel.add(levelLabel);
        
        JPanel monsterPanel = new JPanel();
        monsterPanel.setSize(new Dimension(200, 200));
        monsterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        monsterLabel = new JLabel();
        monsterLabel.setText(monster);
        monsterLabel.setBorder(c);
        monsterPanel.add(monsterLabel);
        
        
        this.add(strengthLabel);
        this.add(goldLabel);
        this.add(levelLabel);
        this.add(monsterLabel);
        
        // Bordure
        Border b =  BorderFactory.createLineBorder(Color.black);
        
        
        this.setBorder(b);
        
    }
    
    public void refresh(Message ar) {
        /**
         * TODO : Completer
         */
        
        strength = "<html><p>Strength :</p></html>";
        gold = "<html><p>Gold : gold</p></html>";
        level = "<html><p>Current level : </p></html>";
        monster = "<html><p>Monsters nearby : </p></html>";

        strengthLabel.setText(strength);
        goldLabel.setText(gold);
        levelLabel.setText(level);
        monsterLabel.setText(monster);
        
    }
    
}
