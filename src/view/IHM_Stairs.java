package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IHM_Stairs extends JFrame{
    
    boolean reponse;


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
        String test = "<html><h2><b>You can enter the new room</h2></p> <br><p>Test</p></html>";
        
        JLabel msg = new JLabel();
        msg.setText(test);
        msg.setPreferredSize(new Dimension(180, 120));

        pMsg.add(msg);
        this.add(pMsg, BorderLayout.CENTER);
        
        bOk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                /**
                 * @TODO : Appel methode ChangerRoom
                 */
            }
        });
        
        bCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    
    public void message() {
        
    }
    
    public boolean isReponse() {
        return reponse;
    }
    
    
}
