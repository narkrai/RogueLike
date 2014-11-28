package model;

/**
 * Objet qui va être envoyé lorsqu'on envoit un message à afficher dans les IHM (sauf les messages actions)
 */
public class Message {

    /**
     * Integer qui va différentier le type du message. 1 : Il ne se passe rien, 2 : Game over, 3 : Victoire, 4 : Teleportation dans une nouvelle room
     */
    private int signal;

    /**
     * String qui va permettre de transmettre un message de type "string"
     */
    private String message;

    /**
     * Room, pour avoir des informations sur la room courante
     */
    private Room room;

    /**
     * Integer qui va nous informer sur le nombre de montre proche du joueur
     */
    private int monsterNearby;

    /**
     * Constructeur sans paramètre
     */
    public Message() {
        super();
    }

    /**
     * Constructeur de message avec paramètres
     * @param signal
     * @param message
     * @param room
     */
    public Message(int signal, String message, Room room) {
        super();
        this.signal = signal;
        this.message = message;
        this.room = room;
    }

    /**
     * Setter de signal
     * @param signal
     */
    public void setSignal(int signal) {
        this.signal = signal;
    }

    /**
     * Getter de signal
     * @return
     */
    public int getSignal() {
        return signal;
    }

    /**
     * Setter de string message, le message qui sera à afficher
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter de string message, le message qui sera à afficher
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter de room
     * @param room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Getter de room
     * @return
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Setter de monsterNearby
     * @param monsterNearby
     */
    public void setMonsterNearby(int monsterNearby) {
        this.monsterNearby = monsterNearby;
    }

    /**
     * Getter de monsterNearby
     * @return
     */
    public int getMonsterNearby() {
        return monsterNearby;
    }
}
