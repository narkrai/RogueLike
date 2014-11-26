package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;

import model.Message;
import model.Player;

/**
 * JFrame qui va se lancer quand le joueur trouve la sortie. Le congratule, lui indique son score et indique le high score
 * @author : Nicolas Nguyen
 */

public class IHM_Exit extends JFrame{
    
    private     String      msgTitre;           // String du titre
    private     JLabel      msgTitreLabel;      // JLabel pour le titre
    private     String      msg;                // String du message
    private     JTextArea   msgTextArea;        // JTextArea qui va contenir le message
    
    /**
     * Constructeur de la JFrame IHM_Exit
     */
    public IHM_Exit() {
        this.setTitle("Game Over!");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        Border b = BorderFactory.createEmptyBorder(1,1,1,1);    // Bordure invisible
        Font font = new Font("Arial", Font.BOLD, 12);           // Police qui sera utilisé dans le JTextArea pour match la police des autres parties de l'interface

        JPanel pMsg = new JPanel();                             // JPanel pour toute la frame
        pMsg.setBorder(b);
        pMsg.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        // Titre
        msgTitreLabel = new JLabel();
        msgTitreLabel.setHorizontalAlignment(JLabel.CENTER);
        msgTitre = "<html><h2><b><center>Congratulation!</center> <br>" +
                   "<center>You have beaten the game!</center></b></h2></p></html>";
        msgTitreLabel.setText(msgTitre);
        pMsg.add(msgTitreLabel);
        
        //Message
        msgTextArea = new JTextArea();
        msgTextArea.setColumns(17);
        msgTextArea.setRows(12);
        msgTextArea.setWrapStyleWord(true);
        msgTextArea.setLineWrap(true);
        msgTextArea.setEditable(false);  
        msgTextArea.setCursor(null);  
        msgTextArea.setOpaque(false);  
        msgTextArea.setFocusable(false);
        msgTextArea.setFont(font);
        pMsg.add(msgTextArea);
        
        this.add(pMsg, BorderLayout.CENTER);
        
        // JPanel des buttons
        JPanel pButton = new JPanel(new GridBagLayout());
        JButton bReplay = new JButton("Try again");
        JButton bClose = new JButton("Close");
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        pButton.add(bReplay,c);
        c.gridx = 1;
        c.gridy = 0;
        pButton.add(bClose,c);
        this.add(pButton, BorderLayout.SOUTH);
        
        // ActionListener du bouton Replay
        bReplay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);                              // Ferme la frame
                Game.getInstance().restart();                   // Restart la game
                IHM_Controls.getInstance().setPlayable(true);   // Remet la playability à true
                IHM_Board.getInstance().refresh();              // Refresh la board pour la nouvelle game
                IHM_Recap.getInstance().refresh();              // Refresh le recap pour la nouvelle game
            }
        });
        
        // ActionListener du bouton Close
        bClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);                              // Ferme la frame
            }
        });
    }
    
    /**
     * Methode qui va refresh le message
     * @param Message
     */
    public void refresh(Message m) {
        int score = Player.getInstance().getGold()*2 + Player.getInstance().getStrength()*3;
        msg = "Your score : "+score+".";
        msgTextArea.setText(msg);
    }
    
}
