package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;

import model.Message;

public class IHM_Recap extends JPanel{
    
    private     JLabel      strengthLabel;
    private     JLabel      goldLabel;
    private     JLabel      levelLabel;
    private     JLabel      monsterLabel;
    
    private     String      strength        = "";
    private     String      gold            = "";
    private     String      level           = "";
    private     String      monster         = "";

    /**
     * Constructeur de la classe IHM_Recap, la partie droite de l'interface qui récapitule la situation dans le jeu : force, or, niveau et monstres proches
     */
    public IHM_Recap() {
        this.setPreferredSize(new Dimension(200, 300));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Border c =  BorderFactory.createEmptyBorder(5,5,30,5);  // Bordure invisible entre chaque JLabel
        
        strength    = "<html><p>Strength :</p></html>";
        gold        = "<html><p>Gold : gold</p></html>";
        level       = "<html><p>Current level : </p></html>";
        monster     = "<html><p>Monsters nearby : </p></html>";
        
        // Force
        JPanel strengthPanel = new JPanel();
        strengthPanel.setSize(new Dimension(200, 200));
        strengthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        strengthLabel = new JLabel();
        strengthLabel.setText(strength);
        strengthLabel.setBorder(c);
        strengthPanel.add(strengthLabel);
        
        // Or
        JPanel goldPanel = new JPanel();
        goldPanel.setSize(new Dimension(200, 200));
        goldPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        goldLabel = new JLabel();
        goldLabel.setText(gold);
        goldLabel.setBorder(c);
        goldPanel.add(goldLabel);
        
        // Niveau
        JPanel levelPanel = new JPanel();
        levelPanel.setSize(new Dimension(200, 200));
        levelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        levelLabel = new JLabel();
        levelLabel.setText(level);
        levelLabel.setBorder(c);
        levelPanel.add(levelLabel);
        
        // Monstres proches
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
        
        refresh(new Message());
        
        // Bordure noire autour du panel
        Border b =  BorderFactory.createLineBorder(Color.black);
        this.setBorder(b);
    }
    
    /**
     * Méthode qui va refresh les informations.
     * @param Message
     */
    public void refresh(Message ar) {
        strength    = "<html><p>Strength : "+Game.getInstance().getPlayer().getStrength()+"</p></html>";
        gold        = "<html><p>Gold : "+Game.getInstance().getPlayer().getGold()+" gold</p></html>";
        level       = "<html><p>Current level : "+Game.getInstance().getCurrentLevel() +"</p></html>";
        monster     = "<html><p>Monsters nearby : "+ar.getMonsterNearby()+ "</p></html>";

        strengthLabel.setText(strength);
        goldLabel.setText(gold);
        levelLabel.setText(level);
        monsterLabel.setText(monster);
    }
    
}
