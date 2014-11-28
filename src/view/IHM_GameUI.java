package view;

import controller.Game;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Message;

/**
 * Frame principale de l'application. Va construire et assembler toutes les petites frames/panels ensembles
 * @author : Nicolas Nguyen
 */
@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class IHM_GameUI extends JFrame{

    private             JPanel          eastPan;                    // Panel dans le East, contient le Recap et la console
    private             JPanel          centerPan;                  // Panel dans le Center, contient la board
    private             IHM_Board       board;                      // Board, ce qui contient la carte
    private             IHM_Recap       sumPanel;                   // Recap, ce qui contient la force du joueur, le niveau courant et les monstres proches
    private             IHM_Controls    controls;                   // TextField où le joueur fait ses input pour se déplacer
    private             IHM_Message     msgPanel;                   // Console, résume ce qu'il se passe
    private             IHM_GameOver    gameOverPanel;              // JFrame qui s'affiche lorsque le joueur meurt
    private             IHM_Exit        exitPanel;                  // JFrame qui s'affiche lorsque le joueur trouve la sortie
    private             IHM_Stairs      stairsPanel;                // JFrame qui s'affiche lorsque le joeur trouve un escalier montant
    private static      IHM_GameUI      uniqueInstance = null;      // Instance de la GameUI, pour le singleton

    /**
     * Constructeur de la gameUI
     */
    public IHM_GameUI() {
        this.setTitle("Rogue");
        this.setSize(750,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        Border b = BorderFactory.createEmptyBorder(1,1,1,1);        // Bordure noire
        Border b2 = BorderFactory.createEmptyBorder(1,0,1,1);       // Bordure noire mais 1px en moins, pour plus joli
        
        gameOverPanel = new IHM_GameOver();
        exitPanel = new IHM_Exit();
        sumPanel = IHM_Recap.getInstance();
        msgPanel = IHM_Message.getInstance();
        
        // Panel au centre, le board
        board = IHM_Board.getInstance();
        board.refresh();
        centerPan = new JPanel();
        centerPan.setBorder(b);
        centerPan.setLayout(new BorderLayout());
        centerPan.add(board);
        
        this.add(centerPan, BorderLayout.CENTER);
        
        // Panel à droite, ce qui est Recap + Message
        eastPan = new JPanel();
        GridLayout gl = new GridLayout(2,0);
        gl.setVgap(1);
        eastPan.setLayout(gl);
        eastPan.add(sumPanel);
        eastPan.add(msgPanel);
        eastPan.setBorder(b2);
        this.add(eastPan, BorderLayout.EAST);

        // Panel à bas, ce qui est control
        controls = IHM_Controls.getInstance();
        this.add(controls, BorderLayout.SOUTH);

        // Ajoute la menuBar à la frame
        this.setJMenuBar(new MenuBar());
        this.setVisible(true);
    }
    
    /**
     * Méthode utilisé pour intégration du design pattern singleton
     * @return Instance IHM_GameUI
     */
    public static IHM_GameUI getInstance()
    {
        if (uniqueInstance == null) 
        {
            try 
            {
            uniqueInstance = new IHM_GameUI();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        return uniqueInstance;
    }
    
    /**
     * Methode qui va analyser le signal du message reçu
     * @param MessageIHM
     */
    public void analyse (Message ar) {
        final int RIEN = 0;         // signal = 0 = rien
        final int GAMEOVER = 1;     // signal = 1 = gameOver
        final int WIN = 2 ;         // signal = 2 = win
        final int TELEPORT = 3 ;    // signal = 3 = teleport
        
        switch(ar.getSignal()) {
            case RIEN :
            board.refresh();
            sumPanel.refresh();
            msgPanel.refresh(ar);
            break;
            case GAMEOVER :
            controls.setPlayable(false);
            gameOverPanel.refresh(ar);
            gameOverPanel.setVisible(true);
            break;
            case WIN :
            controls.setPlayable(false);
            exitPanel.refresh();
            exitPanel.setVisible(true);
            break;
            case TELEPORT :
            controls.setPlayable(false);
            stairsPanel = new IHM_Stairs(ar);
            stairsPanel.setVisible(true);
            break;  
        }  
    }

    /**
     * Methode qui va faire une nouvelle game
     */
    public void newGame() {
        Game.getInstance().restart();                   // Restart la game
        IHM_Controls.getInstance().setPlayable(true);   // Remet la playability à true
        IHM_Board.getInstance().refresh();              // Refresh la board pour la nouvelle game
        IHM_Recap.getInstance().refresh();              // Refresh le recap pour la nouvelle game
        IHM_Message.getInstance().setEmpty();
        
    }
}
