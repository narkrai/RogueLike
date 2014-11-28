package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.border.Border;
import model.HighScore;

/**
 * JFrame qui va afficher les highscores.
 * Lors de l'appel de la fonction refresh(), elle va lire le fichier "score.txt" et, pour chaque ligne, crée un objet "HighScore" qui sera stocké dans un ArrayList.
 * Cette ArrayList est trié puis on affiche les 5 premiers.
 * @author : Nicolas Nguyen
 */
@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
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
    
    /**
     * Méthode refresh() qui va afficher les 5 meilleurs scores enregistrés sur le fichier "score.txt".
     * La methode lit le fichier, transforme le contenue en ArrayList de HighScore, la trie et affiche les 5 premiers scores.
     */

    public void refresh() {
        msg="";
        
        try {
            FileReader reader = new FileReader("score.txt");                                // Ouverture du fichier "score.txt"
            BufferedReader br = new BufferedReader(reader);                                 // Crée un buffer avec le fichier "score.txt"
            String aLine;                                                                   // Un string qui contient la ligne courante
            int i=0;                                                                        // Int compteur
            ArrayList<HighScore> hsList = new ArrayList<HighScore>();                       // Initialise l'ArrayList de HighScore
            
            // Lecture du fichier et ajout des highscore dans l'arraylist
            while ((aLine = br.readLine()) != null) {
                String[] aPlayer = aLine.split(";");
                hsList.add(new HighScore(aPlayer[0], Integer.parseInt(aPlayer[1])));
            }
            
            Collections.sort(hsList, Collections.reverseOrder());                           // Trie de l'arrayList en décroissant
            
            // Si on a assez de HighScore pour en afficher 5
            if (hsList.size() > 5) {
                for (i=0; i<5; i++) {                   
                    msg+=hsList.get(i).getName()+" - "+hsList.get(i).getScore()+"\n";
                }
            }
            else { // sinon
                for (i=0; i<hsList.size(); i++) {
                    msg+=hsList.get(i).getName()+" - "+hsList.get(i).getScore()+"\n";
                }
            }

            msgTextArea.setText(msg);
            reader.close();                                                                     // Fermeture du File
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("IOException occurred");
        }
    }
}
