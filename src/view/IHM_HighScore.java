package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;

import java.util.ArrayList;

import java.util.Collection;

import java.util.Collections;

import javax.swing.border.Border;

import javax.swing.text.Highlighter;

import model.HighScore;
import model.Message;

/**
 * JFrame qui va afficher les highscores
 * @author : Nicolas Nguyen
 */
public class IHM_HighScore extends JFrame{
        
    private     String      msgTitre;           // String du titre
    private     JLabel      msgTitreLabel;      // JLabel pour le titre
    private     String      msg;                // String du message
    private     JTextArea   msgTextArea;        // JTextArea qui va contenir les scores
    
    /**
     * Méthode constructeur de IHM_HighScore
     */
    public IHM_HighScore() {
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);

        Border b = BorderFactory.createEmptyBorder(1,1,1,1);    // Bordure invisible
        Font font = new Font("Arial", Font.BOLD, 12);           // Police qui sera utilisé dans le JTextArea pour match la police des autres parties de l'interface
        
        

        
        
        
        
        
        
        
        
        
        
        
        JPanel pMsg = new JPanel();                             // JPanel pour toute la frame
        pMsg.setBorder(b);
        pMsg.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        // Titre
        msgTitreLabel = new JLabel();
        msgTitreLabel.setHorizontalAlignment(JLabel.CENTER);
        msgTitre = "<html><h2><b>High Score</b></h2></p></html>";
        msgTitreLabel.setText(msgTitre);
        pMsg.add(msgTitreLabel);
        
        // Messge
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
        
        refresh();
               
        this.add(pMsg, BorderLayout.CENTER);
               
        // Panel des buttons
        JPanel pButton = new JPanel(new GridBagLayout());
        JButton bClose = new JButton("Close");
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        pButton.add(bClose,c);
        this.add(pButton, BorderLayout.SOUTH);

        // ActionListener sur le bouton CLose
        bClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);                              // Ferme la frame
            }
        });
        
    }
    
    public void refresh() {
        File myFile = new File("score.txt");
        msg="";
        
        try {

            FileReader reader = new FileReader("score.txt");
            BufferedReader br = new BufferedReader(reader);
            String aLine;
            int i=0;
            
            ArrayList<HighScore> hsList = new ArrayList<HighScore>();
            
            while ((aLine = br.readLine()) != null) {
                String[] aPlayer = aLine.split(";");
                hsList.add(new HighScore(aPlayer[0], Integer.parseInt(aPlayer[1])));
            }
            
            Collections.sort(hsList, Collections.reverseOrder());
            
            if (hsList.size() > 5) {
                for (i=0; i<5; i++) {                   
                    msg+=hsList.get(i).getName()+" - "+hsList.get(i).getScore()+"\n";
                }
            }
            else {
                for (i=0; i<hsList.size(); i++) {
                    msg+=hsList.get(i).getName()+" - "+hsList.get(i).getScore()+"\n";
                }
            }

            msgTextArea.setText(msg);
            
            
            reader.close();
             
        } catch (FileNotFoundException e) 
        {
            System.out.println("File not found");
        } catch (IOException e)
                {
            System.out.println("IOException occurred");
        }
        
    }
    
}
