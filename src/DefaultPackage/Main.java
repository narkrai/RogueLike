package DefaultPackage;

import controller.Game;

import view.IHM_GameUI;

public class Main {
    
    private static Main instance = null;
    
    public static void main(String[] args ) {
        
        IHM_GameUI.getInstance();
    }
    

}
