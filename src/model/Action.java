package model;

/**
 * Classe Action. Représente l'objet envoyé par les différentes méthodes "Actions"
 */
public class Action {
    
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
