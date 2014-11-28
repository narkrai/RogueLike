package model;

/**
 * Classe Action. Représente l'objet envoyé par les différentes méthodes "Actions"
 * Cette classe permet la communication entre les Items et le Game
 * @author Nguyen
 */
public class Action {

    //constante de valeurs entre Game et action
    //private final int NORMAL = 0;
    //private final int VICTORY = 1;
    //private final int LOSE = 2;

    /**
     * numero du signal (NORMAL VICTORY ou  LOSE)
     */
    private int signal;

    /**
     * String de l'Action
     */
    private String message;

    /**
     * Constructeur d'Action
     * @param signal numero du signal (NORMAL VICTORY ou  LOSE)
     * @param message String de l'Action
     */
    public Action(int signal, String message) {
        this.signal = signal;
        this.message = message;
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
}
