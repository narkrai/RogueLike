package model;

import controller.Game;

public class Exit extends Item {
    public Exit() {
        super();
    }


    @Override
    public Message Action(Player p) {
        return new Message(1, "Exit");
    }
}
