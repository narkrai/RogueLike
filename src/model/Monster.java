package model;

import controller.Game;

import java.util.Random;

public class Monster extends Character {
    private int strength = 10;
    private int gold;
    private String name;
    private int level;
    
    //constante de valeurs entre Game et action
    private final int NORMAL = 0 ;
    private final int VICTORY = 1;
    private final int LOSE = 2;
    
    
    final char CHARACTER = '!';

    public Monster() {
        super();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return this.gold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Monster(String name, int strength, int gold, int level) {
        super();
        this.strength = strength;
        this.gold = gold;
        this.name = name;
        this.level = level;
    }


    public Action action(Player p) {
        Action res = null;
        
        Random rand = new Random();
        int chance = rand.nextInt(100);
        
        double valeurmin = (p.getStrength() + this.getStrength());
        valeurmin = p.getStrength()/valeurmin;
        
        int proba =(int) (valeurmin*100);
        if (chance <= proba) {
            
            int goldNow = p.getGold()+this.getGold();
            p.setGold(goldNow) ;
            res = new Action(VICTORY , "Vous avez battu "+this.getName()+" de force "+ this.getStrength()+". Vous recevez "+this.getGold()+ "pièces d'or.");
        }
        else 
        {
            res = new Action(LOSE, "Vous avez perdu contre "+this.getName()+" de force "+this.getStrength()+". Vous recevez "+this.getGold() +"pièces d'or.");
        }
        return res;
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
    
    
    public static void main(String[] args ){
        
        Player p =  Player.getInstance();
        
        Monster m = new Monster("boss",1,45,1);
        
        System.out.println(m.action(p).getSignal());
        
        
    }
}


