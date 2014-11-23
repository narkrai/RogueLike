package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;

import model.Message;
import model.Player;

public class IHM_Exit extends JFrame{
    
    private JLabel msgTitreLabel;
    private JTextArea msgTextArea;
    private String msgTitre;
    private String msg;
    
    public IHM_Exit() {
        Border b = BorderFactory.createEmptyBorder(1,1,1,1);
        Font font = new Font("Arial", Font.BOLD, 12);
        
        this.setTitle("Game Over!");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        
        JPanel pMsg = new JPanel();
        pMsg.setBorder(b);
        pMsg.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Message h2
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
        this.add(pMsg, BorderLayout.CENTER);
        
        // Panel des buttons
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
        
        bReplay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Game.getInstance().restart();
                setVisible(false);
                IHM_Controls.getInstance().setPlayable(true);
                IHM_Board.getInstance().refresh();
            }
        });
        
        bClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                /**
                 * @TODO : Désactiver les controls
                 */
            }
        });
    }
    
    public void refresh(Message m) {
        int score = Player.getInstance().getGold()*2 + Player.getInstance().getStrength()*3;
        msg = "Your score : "+score+".";
        msgTextArea.setText(msg);
    }
    
}
