package view;

import javax.swing.*;
import java.awt.*;

public class IHM_GameOver extends JFrame{
    public IHM_GameOver() {
        this.setTitle("Game over");
        this.setSize(400,350);
        this.setLocationRelativeTo(null);
        
        JPanel pButton = new JPanel(new GridBagLayout());
        JButton b1 = new JButton("Ok");
        JButton b2 = new JButton("Cancel");
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        pButton.add(b1,c);
        c.gridx = 1;
        c.gridy = 0;
        pButton.add(b2,c);
        this.add(pButton, BorderLayout.SOUTH);
        
        JPanel pMsg = new JPanel();
        String test = "<html><h2><b>Game over</h2></p> <br><p>Test</p></html>";
        
        JLabel msg = new JLabel();
        msg.setText(test);
        msg.setPreferredSize(new Dimension(180, 120));

        pMsg.add(msg);
        this.add(pMsg, BorderLayout.CENTER);
        
    }

    public void message() {
    }
}
