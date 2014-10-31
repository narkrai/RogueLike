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
        final IHM_Exit exit = new IHM_Exit();
        final IHM_Stairs stairs = new IHM_Stairs();
        
        // Déclaration des JMenu et JMenuItem
        JMenu game = new JMenu("Game");
        JMenu help = new JMenu("?");
        JMenuItem newGame = new JMenuItem("New game");
        JMenuItem option = new JMenuItem("Option");
        
        
        // Ajoute les menu dans la barre
        this.add(game);
        this.add(help);
        
        // Ajoute les sous-menu dans les menu
        game.add(newGame);
        game.add(option);
        
        //Actionlistener
        option.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                optionFrame.setVisible(true);
            }
        });
        
        //Menu pour tester les frames popup, à supprimer
        JMenu TestFrame = new JMenu("Test de frame");
        JMenuItem gom = new JMenuItem("GameOver");
        TestFrame.add(gom);
        this.add(TestFrame);
        gom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                go.setVisible(true);
            }
        });
        JMenuItem exm = new JMenuItem("Exit");
        TestFrame.add(exm);
        exm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                exit.setVisible(true);
            }
        });
        JMenuItem stm = new JMenuItem("Stairs");
        TestFrame.add(stm);
        stm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stairs.setVisible(true);
            }
        });
        
    }
}
