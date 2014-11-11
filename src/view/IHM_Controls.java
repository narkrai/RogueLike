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
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        switch (e.getKeyCode()) {
                            // Se d�placer avec les fl�ches directionnelles
                            case 37: // Fl�che de gauche
                                
                                break;
                            case 38: // Fl�che du haut
                                break;
                            case 39: // Fl�che de droite
                                break;
                            case 40: //Fl�che du bas
                                break;
                        
                            // Se d�placer avec les touches du clavier
                            case 68: // d
                                break;
                            case 81: // q
                                break;
                            case 83: // s
                                break;
                            case 90: // z
                                break;
                            
                            
                            // Se d�placer avec le pav� num�rique
                            case 98: // 2
                                break;
                            case 100: // 4
                                break; 
                            case 101: // 5
                                break;
                            case 102: // 6
                                break;
                            case 104: // 8
                                break;

                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                            
                    }
            }
}
