package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Message;

public class IHM_Stairs extends JFrame{
    
    private String messageAAfficher;
    private JLabel msg = new JLabel();
    private Message m;


    public IHM_Stairs(Message message) {
        m = message;
        this.setTitle("Entering new room");
        this.setSize(400,350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
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
        
        JPanel pMsg = new JPanel();
        msg.setText(messageAAfficher);
        //msg.setPreferredSize(new Dimension(180, 120));
        pMsg.add(msg);
        this.add(pMsg, BorderLayout.CENTER);
        
        bOk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                Game.getInstance().TeleportInRoom(m.getRoom());
                setVisible(false);
                
            }
        });
        
        bCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    
    public void refresh(Message m) {
            messageAAfficher = "<html><h2><b>You can enter the next room</h2></p><br><p>There are "+Integer.toString(m.getRoom().GetTotalMonster())+" monsters, and a total of "+Integer.toString(m.getRoom().GetTotalGold())+" golds in the next rooms.</p></html>";
            msg.setText(messageAAfficher);
    }

    
}
