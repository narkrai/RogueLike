package view;

import controller.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class IHM_Controls extends JTextField{
    
    private boolean playable;

    private static IHM_Controls uniqueInstance = null;
    
    public static IHM_Controls getInstance()
    {
        if (uniqueInstance == null) 
        {
            try 
            {
            uniqueInstance = new IHM_Controls();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        return uniqueInstance;
    }
    
    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    public boolean isPlayable() {
        return playable;
    }
    
    public IHM_Controls() {
        this.setPlayable(true);
        KeyListener kl = new MyKeyListener();
        this.addKeyListener(kl);
        this.setFocusable(true);
    }
    
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
                                
                        
                        
                        /*switch (e.getKeyCode()) {
                            // Se d�placer avec les fl�ches directionnelles
                            case 37: // Fl�che de gauche
                            
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(1));
                                break;
                            case 38: // Fl�che du haut
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(2));
                                break;
                            case 39: // Fl�che de droite
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(0));
                                break;
                            case 40: //Fl�che du bas
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(3));
                                break;
                        
                            // Se d�placer avec les touches du clavier
                            case 68: // d
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(0));
                                break;
                            case 81: // q
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(1));
                                break;
                            case 83: // s
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(3));
                                break;
                            case 90: // z
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(2));
                                break;
                            
                            
                            // Se d�placer avec le pav� num�rique
                            case 98: // 2
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(3));
                                break;
                            case 100: // 4
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(1));
                                break; 
                            case 102: // 6
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(0));
                                break;
                            case 104: // 8
                            IHM_GameUI.getInstance().analyse(Game.getInstance().makeStep(2));
                                break;
                            default : 
                                break;
                        }*/
                        
                        e.consume();
                    }
                    
                    @Override
                    public void keyReleased(KeyEvent e) {
                        e.consume();
                            
                    }
            }
}
