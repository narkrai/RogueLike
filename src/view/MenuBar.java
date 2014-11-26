package view;

import controller.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
    private IHM_Options optionFrame = new IHM_Options();
    private IHM_Help helpFrame = new IHM_Help();
    public MenuBar() {
        // Déclaration des JMenu et JMenuItem
        JMenu game = new JMenu("Game");
        JMenu help = new JMenu("?");
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
                /*
                 * NOT IMPLEMENTED YET
                 */
            }
        });
        
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Game.getInstance().restart();
                IHM_Board.getInstance().refresh();
                IHM_Controls.getInstance().setPlayable(true);
                IHM_Recap.getInstance().refresh();
            }
        });
        
        apropos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                helpFrame.setVisible(true);
            }
        });

        
    }
}
