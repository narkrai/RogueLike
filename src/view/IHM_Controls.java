package view;

import controller.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class IHM_Controls extends JTextField{
    public IHM_Controls() {
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
                        switch (e.getKeyCode()) {
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

                            
                        }
                        
                        e.consume();
                    }
                    


                    @Override
                    public void keyReleased(KeyEvent e) {
                        e.consume();
                            
                    }
            }
}
