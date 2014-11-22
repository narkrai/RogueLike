package model;

public class Player extends Character {

    private int monsterKilled=0;
    
    final char CHARACTER = '@';

    public void setMonsterKilled(int monsterKilled) {
        this.monsterKilled = monsterKilled;
    }

    public int getMonsterKilled() {
        return monsterKilled;
    }

    /**
     * @aggregation composite
     */
    private static Player uniquePlayer = null;
    
    public static Player getInstance(){
        if (uniquePlayer == null) {
            try {
            uniquePlayer = new Player(0,10,"Jean Kevin de la tour ");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        return uniquePlayer;
    }

    private Player(int gold, int strength, String name) {
        this.setGold(gold);
        this.setStrength(strength);
        this.setName(name);
    }

    @Override
    public Action action(Player p) {
        return null;
    }

    @Override
    public char getCHARACTER() {
       
        return this.CHARACTER;
    }
}
