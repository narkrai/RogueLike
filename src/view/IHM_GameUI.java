package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.border.Border;

import model.Message;

public class IHM_GameUI extends JFrame{
    private JPanel eastPan;
    private JPanel centerPan;
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
        this.setResizable(false);
        
        Border b = BorderFactory.createEmptyBorder(1,1,1,1);
        Border b2 = BorderFactory.createEmptyBorder(1,0,1,1);
        
        sumPanel = new IHM_Recap(0,0,0);
        msgPanel = new IHM_Message(new Message(0, "test"));
        
        // Panel au centre, le board
        int x=20,y=10;
        board = new IHM_Board(x,y);
        centerPan = new JPanel();
        centerPan.setBorder(b);
        //centerPan.setLayout(new BorderLayout());
        centerPan.setPreferredSize(new Dimension(500,500));
        centerPan.add(board);
        
        
        this.add(centerPan, BorderLayout.CENTER);
        
        // Panel � droite, ce qui est Recap + Message
        eastPan = new JPanel();
        GridLayout gl = new GridLayout(2,0);
        gl.setVgap(1);
        eastPan.setLayout(gl);
        eastPan.add(sumPanel);
        eastPan.add(msgPanel);
        eastPan.setBorder(b2);
        this.add(eastPan, BorderLayout.EAST);

        // Panel � bas, ce qui est control
        controls = new IHM_Controls();
        this.add(controls, BorderLayout.SOUTH);

        // Ajoute la menuBar � la frame
        this.setJMenuBar(new MenuBar());
        
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
