package view;

import javax.swing.*;
import java.awt.*;

public class IHM_Stairs extends JFrame{
    
    boolean reponse;


    public IHM_Stairs() {
        this.setTitle("Entering new room");
        this.setSize(400,350);
        this.setLocationRelativeTo(null);
    }
    
    public void message() {
        
    }
    
    public boolean isReponse() {
        return reponse;
    }
    
    
}
