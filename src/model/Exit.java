package model;

import controller.Game;
import model.Action;

public class Exit extends Item {
    
    final char CHARACTER = 'O';
    
    public Exit() {
        super();
        
    }


    @Override
    public Action action(Player p) {
        return new Action(1, "Exit");
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
}
