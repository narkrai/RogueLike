package model;

import controller.Game;

public abstract class Item {

    private char CHARACTER;

    public void setCHARACTER(char CHARACTER) {
        this.CHARACTER = CHARACTER;
    }

    public char getCHARACTER() {
        return CHARACTER;
    }

    public abstract Message Action(Player p);
    
    
        
}
