package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Menu de l'interface
 * @author Nicolas Nguyen
 */

@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class MenuBar extends JMenuBar{
    
    private     IHM_Options         optionFrame     = new IHM_Options();        // JFrame Option
    private     IHM_Help            helpFrame       = new IHM_Help();           // JFrame Help
    private     IHM_HighScore       highscoreFrame  = new IHM_HighScore();      // JFrame HighScore
    
    /**
     * Constructeur du MenuBar
     */
    public MenuBar() {
        // Déclaration des JMenu
        JMenu game = new JMenu("Game");
        JMenu help = new JMenu("?");
        
        // Déclaration des JMenuItem
        JMenuItem newGame = new JMenuItem("New game");
        JMenuItem option = new JMenuItem("Option");
        JMenuItem hs = new JMenuItem("High Score");
        JMenuItem apropos = new JMenuItem("A propos");
        
        // Ajoute les menu dans la barre
        this.add(game);
        this.add(help);
        
        // Ajoute les sous-menu dans les menu
        game.add(newGame);
        game.add(hs);
        game.add(option);
        help.add(apropos);
        
        //Actionlistener
        option.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                optionFrame.setVisible(true);
            }
        });
        
        hs.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                highscoreFrame.setVisible(true);
                highscoreFrame.refresh();
            }
        });
        
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                IHM_GameUI.getInstance().newGame();
            }
        });
        
        apropos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                helpFrame.setVisible(true);
            }
        });
    }
}
