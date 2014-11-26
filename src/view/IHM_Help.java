package view;

import controller.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Message;
import model.OptionData;

public class IHM_Help extends JFrame{

    public IHM_Help() {
        Border b = BorderFactory.createEmptyBorder(1,1,1,1);
        Font font = new Font("Arial", Font.BOLD, 12); // Police utilisé par la JTextArea pour match le reste de l'interface
        
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // JPanel de la frame
        JPanel pMsg = new JPanel();
        pMsg.setBorder(b);
        pMsg.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        // Titre
        JLabel msgTitreLabel = new JLabel();
        msgTitreLabel.setHorizontalAlignment(JLabel.CENTER);
        String msgTitre = "<html><h2><b>Rule of the game</b></h2></p></html>";
        msgTitreLabel.setText(msgTitre);
        pMsg.add(msgTitreLabel);

        // Message
        JTextArea msgTextArea = new JTextArea("rule");
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

        // Panel des boutons
        JPanel pButton = new JPanel(new GridBagLayout());
        JButton bCancel = new JButton("Cancel");
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        pButton.add(bCancel,c);
        this.add(pButton, BorderLayout.SOUTH);

        // Action quand on clique sur Cancel
        bCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
