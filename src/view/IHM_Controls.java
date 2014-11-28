package view;

import controller.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * JTextField utilisé pour entrer les commandes de jeu pour se déplacer.
 * @author : Nicolas Nguyen
 */

@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class IHM_Controls extends JTextField{
    
    private                 boolean             playable;                   // Boolean pour indiquer au jeu s'il est encore jouable ou non, désactive si non
    private     static      IHM_Controls        uniqueInstance  = null;     // Variable d'instance, pour le singleton
    
    /**
     * Constructeur IHM_Controls
     */
    public IHM_Controls() {
        this.setPlayable(true);
        KeyListener kl = new MyKeyListener();
        this.addKeyListener(kl);
        this.setFocusable(true);
    }
    
    /**
     * Méthode utilisé pour intégration du design pattern singleton
     * @return Instance IHM_Controls
     */
    public      static      IHM_Controls        getInstance() {
        if (uniqueInstance == null) {
            try {
            uniqueInstance = new IHM_Controls();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return uniqueInstance;
    }
    
    /**
     * Setter pour la variable playable
     * @param playable
     */
    public void setPlayable(boolean playable) {
        this.playable = playable;
    }
    
    /**
     * Getter pour la variable playable
     * @return
     */
    public boolean isPlayable() {
        return playable;
    }
        
    /**
     * Class interne MyKeyListener, lit la touche et fait l'action associé à la touche
     */
    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            e.consume();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (playable == true && (e.getKeyCode()==39 || e.getKeyCode()==68 || e.getKeyCode()==102))
                    IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(0));
            // Gauche
            else if (playable == true && (e.getKeyCode()==37 || e.getKeyCode()==81 || e.getKeyCode()==100))
                    IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(1));
            // Haut
            else if (playable == true && (e.getKeyCode()==38 || e.getKeyCode()==90 || e.getKeyCode()==104))
                    IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(2));
            // Bas
            else if (playable == true && (e.getKeyCode()==40 || e.getKeyCode()==83 || e.getKeyCode()==98))
                    IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(3));                       
            e.consume(); 
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            e.consume(); 
        }
    }
}
