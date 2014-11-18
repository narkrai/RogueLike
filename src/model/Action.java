package model;

/**
 * Classe Action. Représente l'objet envoyé par les différentes méthodes "Actions"
 */
public class Action {
    
    //constante de valeurs entre Game et action
    private final int NORMAL = 0 ;
    private final int VICTORY = 1;
    private final int LOSE = 2;
    
    
    
    private int signal;
    private String message;

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
