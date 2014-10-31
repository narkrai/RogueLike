package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
    public MenuBar() {
        //Déclaration frames
        final IHM_Options optionFrame = new IHM_Options();
        final IHM_GameOver go = new IHM_GameOver();
        
        // Déclaration des JMenu et JMenuItem
        JMenu game = new JMenu("Game");
        JMenu help = new JMenu("?");
        JMenuItem newGame = new JMenuItem("New game");
        JMenuItem test = new JMenuItem("Test");
        JMenuItem option = new JMenuItem("Option");
        
        // Ajoute les menu dans la barre
        this.add(game);
        this.add(help);
        
        // Ajoute les sous-menu dans les menu
        game.add(newGame);
        game.add(test);
        game.add(option);
        
        //Actionlistener
        option.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                optionFrame.setVisible(true);
            }
        });
        test.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                go.setVisible(true);
            }
        });
    }
}
