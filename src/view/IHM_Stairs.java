package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;

import model.Message;

public class IHM_Stairs extends JFrame{
    
    private JLabel msgTitreLabel;
    private JTextArea msgTextArea;
    private String msgTitre;
    private String msg;
    private Message m;


    public IHM_Stairs(Message message) {
        m = message;
        
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
        msgTitre = "<html><h2><b>Advance to the next floor!</b></h2></p></html>";
        
        msgTitreLabel.setText(msgTitre);
        pMsg.add(msgTitreLabel);
        
        //Message
        
        //msg = "You have died from Wemmert with a strength of 10. He is damn strong";
        
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
        //msgTextArea.setText(msg);
        
        pMsg.add(msgTextArea);
               
        this.add(pMsg, BorderLayout.CENTER);
               
        refresh(m);
        
        JPanel pButton = new JPanel(new GridBagLayout());
        JButton bOk = new JButton("Ok");
        JButton bCancel = new JButton("Cancel");
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        pButton.add(bOk,c);
        c.gridx = 1;
        c.gridy = 0;
        pButton.add(bCancel,c);
        this.add(pButton, BorderLayout.SOUTH);
        
        bOk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                Game.getInstance().TeleportInRoom(m.getRoom());
                setVisible(false);
                IHM_Board.getInstance().refresh();
            }
        });
        
        bCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    
    public void refresh(Message m) {
            msg = "There are "+Integer.toString(m.getRoom().GetTotalMonster())+" monsters, and a total of "+Integer.toString(m.getRoom().GetTotalGold())+" golds in the next rooms.";
            msgTextArea.setText(msg);
    }

    
}
