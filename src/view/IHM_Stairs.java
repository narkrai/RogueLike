package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.border.Border;

import model.Message;

import view.IHM_Controls.MyKeyListener;

/**
 * Frame qui va s'ouvrir lorsque le joueur passe sur un escalier. Il peut valider ou non la prise de l'escalier.
 * @author : Nicolas Nguyen
 */

public class IHM_Stairs extends JFrame{
    
    private     JTextArea   msgTextArea;
    private     String      msg;
    private     Message     m;

    public IHM_Stairs(Message message) {
        m = message;
        Border b = BorderFactory.createEmptyBorder(1,1,1,1);
        Font font = new Font("Arial", Font.BOLD, 12); // Police utilisé par la JTextArea pour match le reste de l'interface
        
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);

        // JPanel de la frame
        JPanel pMsg = new JPanel();
        pMsg.setBorder(b);
        pMsg.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        // Titre
        JLabel msgTitreLabel = new JLabel();
        msgTitreLabel.setHorizontalAlignment(JLabel.CENTER);
        String msgTitre = "<html><h2><b>Advance to the next floor!</b></h2></p></html>";
        msgTitreLabel.setText(msgTitre);
        pMsg.add(msgTitreLabel);

        // Message
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
               
        refresh(m);
        
        // Panel des boutons
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
        
        // Action quand on clique sur OK
        bOk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Game.getInstance().TeleportInRoom(m.getRoom());
                setVisible(false);
                IHM_Board.getInstance().refresh();
                IHM_Recap.getInstance().refresh();
                IHM_Controls.getInstance().setPlayable(true);
            }
        });
        
        // Action quand on clique sur Cancel
        bCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    
    /**
     * Méthode qui va mettre le bon message dans le JTextArea
     * @param Message
     */
    public void refresh(Message m) {
            msg = "There are "+Integer.toString(m.getRoom().GetTotalMonster())+" monsters, and a total of "+Integer.toString(m.getRoom().GetTotalGold())+" golds in the next rooms.";
            msgTextArea.setText(msg);
    }    
}
