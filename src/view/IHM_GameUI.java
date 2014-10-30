package view;

import javax.swing.JFrame;

public class IHM_GameUI extends JFrame{
    
    private IHM_Board board;
    private IHM_Options fenetre;
    private IHM_Recap sumPanel;

    public IHM_GameUI() {
        JFrame GameUI = new JFrame();
        GameUI.setTitle("Rogue");
        GameUI.setSize(1000,1000);
        GameUI.setLocationRelativeTo(null);
        GameUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameUI.setVisible(true);
    }

    public void updateComposants() {
    }

    public void PutComposants() {
    }
    
    public static void main(String[] args) {
        
        IHM_GameUI gui = new IHM_GameUI();
    }
}
