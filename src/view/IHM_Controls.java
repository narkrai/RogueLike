package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class IHM_Controls extends JTextField{
    public IHM_Controls() {
        super();
        
        this.addKeyListener(new KeyAdapter() {
              public void keyReleased(KeyEvent e) {
              }

              public void keyTyped(KeyEvent e) {
              }

              public void keyPressed(KeyEvent e) {
              }
            });
          }
    }
}
