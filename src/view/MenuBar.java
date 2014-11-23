package view;

import controller.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
    private IHM_Options optionFrame = new IHM_Options();
    private IHM_APropos about = new IHM_APropos();
    public MenuBar() {
        // Déclaration des JMenu et JMenuItem
        JMenu game = new JMenu("Game");
        JMenu help = new JMenu("?");
        JMenuItem newGame = new JMenuItem("New game");
        JMenuItem option = new JMenuItem("Option");
        JMenuItem apropos = new JMenuItem("A propos");
        
        
        // Ajoute les menu dans la barre
        this.add(game);
        this.add(help);
        
        // Ajoute les sous-menu dans les menu
        game.add(newGame);
        game.add(option);
        help.add(apropos);
        
        //Actionlistener
        option.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                optionFrame.setVisible(true);
            }
        });
        
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Game.getInstance().restart();
                IHM_Board.getInstance().refresh();
                IHM_Controls.getInstance().setPlayable(true);
            }
        });
        
        apropos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                about.setVisible(true);
            }
        });

        
    }
}
