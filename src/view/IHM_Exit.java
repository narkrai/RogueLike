package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Message;

public class IHM_Exit extends JFrame{
    
    private JLabel msgTitreLabel;
    private JLabel msgLabel;
    private String msgTitre;
    private String msg;
    
    public IHM_Exit() {
        this.setTitle("Congratulation!");
        this.setSize(400,350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        JPanel pMsg = new JPanel();
        //pMsg.setLayout(new BoxLayout(pMsg, BoxLayout.Y_AXIS));
        //Message h2
        msgTitreLabel = new JLabel();
        msgTitre = "<html><h2><center><b>Congratulation!<br> You have beaten the game</b></center></h2></p></html>";
        msgTitreLabel.setText(msgTitre);
        pMsg.add(msgTitreLabel);
        //Message
        msgLabel = new JLabel();
        msg = "<html></html>";
        msgLabel.setText(msg);
        //msgLabel.setPreferredSize(new Dimension(180, 120));
        pMsg.add(msgLabel);
        
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
        /**
         * TODO : compl?ter
         */
        msg = "Your score : ";
        msgLabel.setText(msg);
    }
    
}
