package model;

public class Message {
    
    private int signal;
    private String message;

    public Message(int signal, String message) {
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
