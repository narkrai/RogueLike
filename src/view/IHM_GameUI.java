package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class IHM_GameUI extends JFrame{
    
    private IHM_Board board;
    private IHM_Options fenetre;
    private IHM_Recap sumPanel;

    public IHM_GameUI() {
        this.setTitle("Rogue");
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sumPanel = new IHM_Recap();
        this.add(sumPanel, BorderLayout.EAST);
        
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

    public void PutComposants() {
    }
    
    public static void main(String[] args) {
        
        IHM_GameUI gui = new IHM_GameUI();
    }
}
