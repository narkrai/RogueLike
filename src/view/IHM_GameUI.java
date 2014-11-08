package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import model.Message;

public class IHM_GameUI extends JFrame{
    
    private IHM_Board board;
    private IHM_Options fenetre;
    private IHM_Recap sumPanel;
    private IHM_Controls controls;

    public IHM_GameUI() {
        this.setTitle("Rogue");
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /**
         * @TODO : Créer un joueur
         */
        //sumPanel = new IHM_Recap(Game.getInstance().getPlayer().getGold(), Game.getInstance().getPlayer().getMonsterKilled());
        sumPanel = new IHM_Recap(0,0, new Message(0, "Test message"));
        this.add(sumPanel, BorderLayout.EAST);
        
        controls = new IHM_Controls();
        this.add(controls, BorderLayout.SOUTH);
        
        /*JPanel pan = new JPanel();
        pan.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();*/
        
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
