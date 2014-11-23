package model;
 /**
  * La classe Player définit le joueur 
  * Il hérite de la classe Character
  * @author Dinar
  */
public class Player extends Character {

    /**
     * Nombre de Monsters tués par le Player
     */
    private int monsterKilled=0;
    /**
     * objet Player unique
     */
    private static Player uniquePlayer = null;
    
    
    final char CHARACTER = '@';
    /**
     * Constructeur de Player
     * @param gold somme du Player
     * @param strength force du Player
     * @param name nom du Player
     */
    private Player(int gold, int strength, String name) {
        this.setGold(gold);
        this.setStrength(strength);
        this.setName(name);
    }

    public void setMonsterKilled(int monsterKilled) {
        this.monsterKilled = monsterKilled;
    }

    public int getMonsterKilled() {
        return monsterKilled;
    }

    /**
     * obtention de l'instance unique
     * @return
     */
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

    /**
     * Action inutile  pour le moment car un Player ne peut pas interagir avec lui-meme
     * @param player le joueur
     * @return le message Action (null)
     */
    @Override
    public Action action(Player p) {
        return null;
    }

    @Override
    public char getCHARACTER() {
       
        return this.CHARACTER;
    }
}
