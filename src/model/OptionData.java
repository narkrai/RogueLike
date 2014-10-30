package model;

import controller.Game;

public class OptionData {

   
    private int depthmax;
    private int doormax;
    private int MonsterLuck;
    private int LadderLuck;
    private int PotionLuck;
    private int voidLuck;
    
    private int minPowerPotion;
    private int maxPowerPotion;
    
    private int minGoldTresaure;
    private int maxGoldTresaure;
   
   
   
    private OptionData DataInstance = new OptionData();


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
        this.MonsterLuck = MonsterLuck;
    }

    public int getMonsterLuck() {
        return MonsterLuck;
    }

    public void setLadderLuck(int LadderLuck) {
        this.LadderLuck = LadderLuck;
    }

    public int getLadderLuck() {
        return LadderLuck;
    }

    public void setPotionLuck(int PotionLuck) {
        this.PotionLuck = PotionLuck;
    }

    public int getPotionLuck() {
        return PotionLuck;
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
