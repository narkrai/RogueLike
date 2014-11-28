package model;


/**
 * Character est un Item contentant des données se referant aux personnages du jeu
 * @author Dinar
 */
public abstract class Character extends Item {

    private int strength;
    private int gold;
    private String name;
    private int level;


    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}

