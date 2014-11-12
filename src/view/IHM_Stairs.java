package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IHM_Stairs extends JFrame{
    
    boolean reponse=false;
    private String message;
    private JLabel msg = new JLabel();


    public IHM_Stairs() {
        this.setTitle("Entering new room");
        this.setSize(400,350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
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
        msg.setText(message);
        //msg.setPreferredSize(new Dimension(180, 120));
        pMsg.add(msg);
        this.add(pMsg, BorderLayout.CENTER);
        
        bOk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                reponse=true;
                setVisible(true);
            }
        });
        
        bCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                reponse=false;
                setVisible(false);
            }
        });
    }
    
    public void refresh(int nbGold, int nbMonster) {
        message = "<html><h2><b>You can enter the next room</h2></p><br><p>There are "+Integer.toString(nbMonster)+" monsters, and a total of "+Integer.toString(nbGold)+" golds in the next rooms.</p></html>";
        msg.setText(message);
    }
    
    public boolean isReponse() {
        return reponse;
    }
    
    
}
