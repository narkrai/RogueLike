package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.border.Border;

import model.Message;
import model.MessageIHM;

public class IHM_GameUI extends JFrame{

    
    private JPanel eastPan;
    private JPanel centerPan;
    
    private IHM_Board board;
    private IHM_Options fenetre;
    private IHM_Recap sumPanel;
    private IHM_Controls controls;
    private IHM_Message msgPanel;
    private IHM_GameOver gameOverPanel;
    private IHM_Exit exitPanel;
    private IHM_Stairs stairsPanel;
    
    private static IHM_GameUI uniqueInstance = null;
    
    private Game game = Game.getInstance();

    public static IHM_GameUI getInstance()
    {
        if (uniqueInstance == null) 
        {
            try 
            {
            uniqueInstance = new IHM_GameUI();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        return uniqueInstance;
    }

    public IHM_GameUI() {
        this.setTitle("Rogue");
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        Border b = BorderFactory.createEmptyBorder(1,1,1,1);
        Border b2 = BorderFactory.createEmptyBorder(1,0,1,1);
        
        gameOverPanel = new IHM_GameOver();
        exitPanel = new IHM_Exit();
        stairsPanel = new IHM_Stairs();
        sumPanel = new IHM_Recap(0,0,0);
        msgPanel = new IHM_Message(new Message(0, "test"));
        
        
        // Panel au centre, le board
        board = new IHM_Board(game.getCurrentRoom().getTailleX(),game.getCurrentRoom().getTailleY());
        board.refresh();
        centerPan = new JPanel();
        centerPan.setBorder(b);
        centerPan.setLayout(new BorderLayout());
        //centerPan.setPreferredSize(new Dimension(200,200));
        centerPan.add(board);
        
        
        this.add(centerPan, BorderLayout.CENTER);
        
        // Panel à droite, ce qui est Recap + Message
        eastPan = new JPanel();
        GridLayout gl = new GridLayout(2,0);
        gl.setVgap(1);
        eastPan.setLayout(gl);
        eastPan.add(sumPanel);
        eastPan.add(msgPanel);
        eastPan.setBorder(b2);
        this.add(eastPan, BorderLayout.EAST);

        // Panel à bas, ce qui est control
        controls = new IHM_Controls();
        this.add(controls, BorderLayout.SOUTH);

        // Ajoute la menuBar à la frame
        this.setJMenuBar(new MenuBar());
        
        this.setVisible(true);
    }
    
    public void analyse (MessageIHM ar) {
        
        final int RIEN = 0;
        final int GAMEOVER = 1;
        final int WIN = 2 ;
        final int TELEPORT = 3 ;
        
        switch(ar.getSignal()) {
            
        case 0 :
            board.refresh();
            //messageconsole
            
            break;
        case 1 :
            gameOverPanel.setVisible(true);
            //messageIHM
            break;
        case 2 :
            exitPanel.setVisible(true);
            //messageIHM
            break;
        case 3 : 
            stairsPanel.setVisible(true);
            //messageIHM
            break;
        
        
            
        }
                   
                        
        
    }

    public void updateComposants() {
        
        
    }

    public void putComposants() {
    }
    
    
    public static void main(String[] args) {
        
        IHM_GameUI gui = new IHM_GameUI();
        gui.setVisible(true);
    }
}
