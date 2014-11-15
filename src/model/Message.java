package model;

/**
 * Classe qui va être envoyé par les classes controlleurs aux IHM pour afficher des messages
 */

public class Message {
    
    private int signal;
    private String message;
    private Room room;

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

    public Message(int signal, String message, Room room) {
        super();
        this.signal = signal;
        this.message = message;
        this.room = room;
    }

    public Message() {
        super();
    }
}
