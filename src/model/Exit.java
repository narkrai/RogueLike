package model;

import controller.Game;

public class Exit extends Item {
    
    final char CHARACTER = 'O';
    
    public Exit() {
        super();
        
    }


    @Override
    public Action Action(Player p) {
        return new Action(1, "Exit");
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
}
