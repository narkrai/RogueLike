package model;

import controller.Game;

import java.util.ArrayList;

/**
 * L'Option est une classe qui permet de stocké les données utile à la generation des salles et de l'arborescence
 * @author Dinar
 */
public class OptionData {

    static private OptionData dataInstance = null;
   /**
    * Profondeur maximal du jeu
    */
    private int depthmax = 2 ;
   /**
    * Nombre maximal de Room dans une Room
    */
    private int doormax = 2;
    
    /**
     * Chance pour qu'un Monster apparaisse sur une CellUnit
     */
    private int monsterLuck = 10;
    /**
     * Chance pour qu'une Room apparaisse sur une Cell
     */
    private int ladderLuck = 10;
    /**
     *     
     * Chance pour qu'une Potion apparaisse sur une CellUnit
     */
    private int potionLuck = 10;
    /**
     * Chance pour qu'un Chest apparaisse sur une CellUnit
     */
    private int treasureLuck = 10;

    /**
     * Chance pour que rien n'apparaisse sur une CellUnit
     */
    private int voidLuck = 60;
    /**
     * Nombre de force minimun d'une potion
     */
    private int minPowerPotion = -7;
    /**
     * Nombre de force maximun d'une potion
     */
    private int maxPowerPotion = 10;
    /**
     * Nombre de Gold minimun d'un Chest
     */
    private int minGoldTresaure =5;
    /**
     * Nombre de Gold  maximun d'un Chest
     */
    private int maxGoldTresaure = 4500;

    /**
     * Largeur d'une room
     */
    private int tailleYRoom = 5;

    /**
     * Longueur d'une room
     */
    private int tailleXRoom = 5;
   
   /**
    * strategie choisie
    */
   private IStrategy strategy;
   /**
    * Nom du joueur
    */
   private String playerName = "Player";
   /**
    * Liste de toutes les strategies
    */
   private ArrayList<IStrategy> listStrategy;


    private OptionData() {
       this.listStrategy = new ArrayList<>();
        this.strategy = new Idiot();
        listStrategy.add(strategy);
        listStrategy.add(new Nice());
    }

    public ArrayList<IStrategy> getListStrategy() {
        return listStrategy;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    
        public void setTreasureLuck(int treasureLuck) {
        this.treasureLuck = treasureLuck;
    }

    public int getTreasureLuck() {
        return treasureLuck;
    } 
    
    
    public void setTailleYRoom(int tailleYRoom) {
        this.tailleYRoom = tailleYRoom;
    }

    public int getTailleYRoom() {
        return tailleYRoom;
    }

    public void setTailleXRoom(int tailleXRoom) {
        this.tailleXRoom = tailleXRoom;
    }

    public int getTailleXRoom() {
        return tailleXRoom;
    }


    public static OptionData getDataInstance() {
        if (dataInstance == null) 
        {
            try 
            {
                dataInstance = new OptionData();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    
        
        return dataInstance;
    }

    public void setDepthmax(int depthmax) {
        this.depthmax = depthmax;
    }

    public int getDepthmax() {
        return depthmax;
    }

    public void setDoormax(int doormax) {
        this.doormax = doormax;
    }

    public int getDoormax() {
        return doormax;
    }

    public void setMonsterLuck(int MonsterLuck) {
        this.monsterLuck = MonsterLuck;
    }

    public int getMonsterLuck() {
        return monsterLuck;
    }

    public void setLadderLuck(int LadderLuck) {
        this.ladderLuck = LadderLuck;
        this.voidLuck = 100 - this.potionLuck - this.getLadderLuck();
    }

    public int getLadderLuck() {
        return ladderLuck;
    }

    public void setPotionLuck(int PotionLuck) {
        this.potionLuck = PotionLuck;
        this.voidLuck = 100 - this.potionLuck - this.getLadderLuck();
    }

    public int getPotionLuck() {
        return potionLuck;
    }



    public int getVoidLuck() {
        return voidLuck;
    }

    public void setMinPowerPotion(int minPowerPotion) {
        this.minPowerPotion = minPowerPotion;
    }

    public int getMinPowerPotion() {
        return minPowerPotion;
    }

    public void setMaxPowerPotion(int maxPowerPotion) {
        this.maxPowerPotion = maxPowerPotion;
    }

    public int getMaxPowerPotion() {
        return maxPowerPotion;
    }

    public void setMinGoldTresaure(int minGoldTresaure) {
        this.minGoldTresaure = minGoldTresaure;
    }

    public int getMinGoldTresaure() {
        return minGoldTresaure;
    }

    public void setMaxGoldTresaure(int maxGoldTresaure) {
        this.maxGoldTresaure = maxGoldTresaure;
    }

    public int getMaxGoldTresaure() {
        return maxGoldTresaure;
    }
    
    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public IStrategy getStrategy() {
        return strategy;
    }

}
