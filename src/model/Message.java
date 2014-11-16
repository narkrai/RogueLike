package model;

public class Message {
    
    private int signal;
    private String message;
    private Room room;
    private Player player;
    private int monsterNearby;



    public Message() {
        super();

    }



    public Message(int signal, String message, Room room) {
        super();
        this.signal = signal;
        this.message = message;
        this.room = room;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public int getSignal() {
        return signal;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
    
    public void setMonsterNearby(int monsterNearby) {
        this.monsterNearby = monsterNearby;
    }

    public int getMonsterNearby() {
        return monsterNearby;
    }
}
