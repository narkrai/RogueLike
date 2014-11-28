package view;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.border.Border;

import model.OptionData;

/**
 * JFrame pour l'info des auteurs
 * Pourrait intégrer les règles si j'ai le temps
 * @author : Nicolas Nguyen
 */

@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class IHM_Welcome extends JFrame {
    
    private JTextField pTextField;
    
    public IHM_Welcome() {
        Border b = BorderFactory.createEmptyBorder(5,5,5,5); 
        
        this.setTitle("RogueLike");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        // Création d'un JPanel qui va accueilir le bouton, fait dans un JPanel pour ajouter nouveaux boutons plus tard
        JPanel pButton = new JPanel(new GridBagLayout());
        JButton bPlay = new JButton("Play");
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        pButton.add(bPlay,c);
        this.add(pButton, BorderLayout.SOUTH);
        
        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.PAGE_AXIS));
        bigPanel.setBorder(b);
        
        // JPanel pour la partie texte de la JFrame
        JPanel pMsg = new JPanel();
        String text = "<html><h2><b>Rogue like</h2></p> <br><p>proposé par Karim Dinar et Nicolas Nguyen </p></html>";
        JLabel msg = new JLabel();
        msg.setText(text);
        msg.setPreferredSize(new Dimension(180, 120));
        pMsg.add(msg);
        
        // JPanel pour le pseudo
        JPanel pseudoPan = new JPanel();
        pseudoPan.setLayout(new GridLayout(2,0));
        JLabel pLabel = new JLabel("Pseudo : ");
        pTextField = new JTextField();
        pseudoPan.add(pLabel);
        pseudoPan.add(pTextField);
        
        bigPanel.add(pMsg);
        bigPanel.add(pseudoPan);
        
        this.add(bigPanel, BorderLayout.CENTER);
        
        // Actionlistener sur le bouton Close
        bPlay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                OptionData.getInstance().setPlayerName(pTextField.getText());
                setVisible(false);
                IHM_GameUI.getInstance();
            }
        });
        
        this.setVisible(true);
    }

}
