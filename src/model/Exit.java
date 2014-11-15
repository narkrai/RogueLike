package model;

import controller.Game;

public class Exit extends Item {
    
    final char CHARACTER = 'O';
    
    public Exit() {
        super();
        
    }


    @Override
    public Message Action(Player p) {
        return new Message(1, "Exit");
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
}
