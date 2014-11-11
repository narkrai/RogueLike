package model;

import controller.Game;

public class OptionData {

   
    private int depthmax;
    private int doormax;
    private int monsterLuck;
    private int ladderLuck;
    private int potionLuck;
    private int voidLuck;
    
    private int minPowerPotion;
    private int maxPowerPotion;
    
    private int minGoldTresaure;
    private int maxGoldTresaure;
    
    private int tailleYRoom;
    private int tailleXRoom;
   
   
   
    public static OptionData DataInstance = new OptionData();

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
    }

    public int getLadderLuck() {
        return ladderLuck;
    }

    public void setPotionLuck(int PotionLuck) {
        this.potionLuck = PotionLuck;
    }

    public int getPotionLuck() {
        return potionLuck;
    }

    public void setVoidLuck(int voidLuck) {
        this.voidLuck = voidLuck;
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
