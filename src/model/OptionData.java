package model;

import controller.Game;

public class OptionData {

   
    private int depthmax=2;
    private int doormax;
    
    
    private int monsterLuck;
    private int ladderLuck;
    private int potionLuck;
    private int treasureLuck;


    private int voidLuck;
    
    private int strategy=1;



    private int minPowerPotion;
    private int maxPowerPotion;
    
    private int minGoldTresaure;
    private int maxGoldTresaure;
    
    private int tailleYRoom=2;
    private int tailleXRoom=2;
   
   
   
    public static OptionData DataInstance = new OptionData();

    public void setStrategy(int strategy) {
        this.strategy = strategy;
    }

    public int getStrategy() {
        return strategy;
    }

    public void setTailleYRoom(int tailleYRoom) {
        this.tailleYRoom = tailleYRoom;
    }
    
        public void setTreasureLuck(int treasureLuck) {
        this.treasureLuck = treasureLuck;
    }

    public int getTreasureLuck() {
        return treasureLuck;
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

    private OptionData() {
        super();
    }

    public static OptionData getDataInstance() {
        return DataInstance;
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
}
