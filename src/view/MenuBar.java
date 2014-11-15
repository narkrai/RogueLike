package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
    private IHM_Options optionFrame = new IHM_Options();
    private IHM_APropos about = new IHM_APropos();
    
    
    private IHM_GameOver go = new IHM_GameOver();
    private IHM_Exit exit = new IHM_Exit();
    private IHM_Stairs stairs = new IHM_Stairs();
    
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
        
        apropos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                about.setVisible(true);
            }
        });

        //Menu pour tester les frames popup, ? supprimer
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
