package view;

import controller.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class IHM_Recap extends JPanel{
    
    private     JLabel      strengthLabel;
    private     JLabel      goldLabel;
    private     JLabel      levelLabel;
    private     JLabel      monsterLabel;
    
    private     String      strength        = "";
    private     String      gold            = "";
    private     String      level           = "";
    private     String      monster         = "";
    
    private static      IHM_Recap      uniqueInstance = null;

    /**
     * Constructeur de la classe IHM_Recap, la partie droite de l'interface qui récapitule la situation dans le jeu : force, or, niveau et monstres proches
     */
    public IHM_Recap() {
        this.setPreferredSize(new Dimension(200, 300));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Border c =  BorderFactory.createEmptyBorder(5,5,30,5);  // Bordure invisible entre chaque JLabel
        
        int x = Game.getInstance().getCurrentCell().getPositionX();
        int y = Game.getInstance().getCurrentCell().getPositionY();
        strength    = "<html><p>Strength : "+Game.getInstance().getPlayer().getStrength()+"</p></html>";
        gold        = "<html><p>Gold : "+Game.getInstance().getPlayer().getGold()+" gold</p></html>";
        level       = "<html><p>Current level : "+Game.getInstance().getCurrentLevel() +"</p></html>";
        monster     = "<html><p>Monsters nearby : "+Game.getInstance().getCurrentRoom().nbMonsterNear(x, y)+ "</p></html>";
        
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
        
        // Bordure noire autour du panel
        Border b =  BorderFactory.createLineBorder(Color.black);
        this.setBorder(b);
    }
    
    /**
     * Méthode utilisé pour intégration du design pattern singleton
     * @return IHM_Recap
     */
    public static IHM_Recap getInstance()
    {
        if (uniqueInstance == null) 
        {
            try 
            {
            uniqueInstance = new IHM_Recap();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        return uniqueInstance;
    }
    
    /**
     * Méthode qui va refresh les informations.
     * @param Message
     */
    public void refresh() {
        int x = Game.getInstance().getCurrentCell().getPositionX();
        int y = Game.getInstance().getCurrentCell().getPositionY();
        strength    = "<html><p>Strength : "+Game.getInstance().getPlayer().getStrength()+"</p></html>";
        gold        = "<html><p>Gold : "+Game.getInstance().getPlayer().getGold()+" gold</p></html>";
        level       = "<html><p>Current level : "+Game.getInstance().getCurrentLevel() +"</p></html>";
        monster     = "<html><p>Monsters nearby : "+Game.getInstance().getCurrentRoom().nbMonsterNear(x, y)+ "</p></html>";

        strengthLabel.setText(strength);
        goldLabel.setText(gold);
        levelLabel.setText(level);
        monsterLabel.setText(monster);
    }
}
