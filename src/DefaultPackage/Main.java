package DefaultPackage;

import controller.Game;

import view.IHM_GameUI;
import view.IHM_Welcome;

public class Main {
    
    private static Main instance = null;
    
    public static void main(String[] args ) {
        
        new IHM_Welcome();
    }
    

}
