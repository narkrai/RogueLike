package view;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * JFrame pour l'info des auteurs
 * Pourrait intégrer les règles si j'ai le temps
 * @author : Nicolas Nguyen
 */

public class IHM_APropos extends JFrame {
    
    public IHM_APropos() {
        this.setTitle("A propos");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        // Création d'un JPanel qui va accueilir le bouton, fait dans un JPanel pour ajouter nouveaux boutons plus tard
        JPanel pButton = new JPanel(new GridBagLayout());
        JButton bClose = new JButton("Close");
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        pButton.add(bClose,c);
        this.add(pButton, BorderLayout.SOUTH);
        
        // JPanel pour la partie texte de la JFrame
        JPanel pMsg = new JPanel();
        String text = "<html><h2><b>Rogue like</h2></p> <br><p>proposé par Karim Dinar et Nicolas Nguyen </p></html>";
        JLabel msg = new JLabel();
        msg.setText(text);
        msg.setPreferredSize(new Dimension(180, 120));

        pMsg.add(msg);
        this.add(pMsg, BorderLayout.CENTER);
        
        // Actionlistener sur le bouton Close
        bClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

}
