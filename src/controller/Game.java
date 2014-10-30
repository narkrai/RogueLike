package controller;

import java.util.ArrayList;
import java.util.List;

import model.IStrategy;
import model.OptionData;
import model.Player;
import model.Room;

public class Game {
    private IStrategy strategie;
    private Player player;


    
    //TODO metre davantage de param

    private ArrayList<Room> rooms = new ArrayList<Room>();
    /**
     * @aggregation composite
     */
    private static Game uniqueInstance = null;


    public static Game getInstance(){
        if (uniqueInstance == null) {
            try {
            uniqueInstance = new Game();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        return uniqueInstance;
    }

    public Game() {
        super();
    }
    
    public void setStrategie(IStrategy strategie) {
        this.strategie = strategie;
    }
    public IStrategy getStrategie() {
        return strategie;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void Restart() {
        
    }
    
    public void AddRoom() {
        
    }
    
    private void makeStep(int direction){
        
    }
    
    public void GameOver() {
        
    }
    
    public void PlayerWin(){
        
    }
    
    public int getCurrentLevel() {
        
        return 0;
        
    }

    
    
    
    

    
}
