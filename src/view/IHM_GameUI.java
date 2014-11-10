package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import model.Message;

public class IHM_GameUI extends JFrame{
    private JPanel pan;
    private IHM_Board board;
    private IHM_Options fenetre;
    private IHM_Recap sumPanel;
    private IHM_Controls controls;
    private IHM_Message msgPanel;

    public IHM_GameUI() {
        this.setTitle("Rogue");
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sumPanel = new IHM_Recap(0,0,0);
        msgPanel = new IHM_Message(new Message(0, "test"));
        
        
        
        
        /*pan = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(1,1,1,1);
        c.gridx = 0;
        c.gridy = 0;
        pan.add(sumPanel,c);
        c.gridx = 0;
        c.gridy = 1;
        pan.add(msgPanel,c);
        this.add(pan, BorderLayout.EAST);*/
        
        pan = new JPanel();
        pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
        pan.add(sumPanel);
        pan.add(msgPanel);
        this.add(pan, BorderLayout.EAST);

        controls = new IHM_Controls();
        this.add(controls, BorderLayout.SOUTH);
        
        
        
        
        
        
        
        
        
        // Ajoute la menuBar à la frame
        this.setJMenuBar(new MenuBar());
        //this.setContentPane(pan);
        this.setVisible(true);
    }

    public void updateComposants() {
    }

    public void putComposants() {
    }
    
    
    public static void main(String[] args) {
        
        IHM_GameUI gui = new IHM_GameUI();
    }
}
