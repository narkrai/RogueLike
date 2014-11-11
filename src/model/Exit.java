package model;

import controller.Game;

public class Exit extends Item {
    public Exit() {
        super();
        this.setCHARACTER('O');
    }


    @Override
    public Message Action(Player p) {
        return new Message(1, "Exit");
    }
}
