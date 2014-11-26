package model;

import controller.Game;

import java.util.Random;
/**
 * La classe Monster définie tous les monstres que le joueur va rencontrer
 * Ils héritent de la classe Character
 * @author Dinar
 * @author Nicolas Nguyen
 */
public class Monster extends Character {
    
    
    //constante de valeurs entre Game et action
    private final int NORMAL = 0 ;
    private final int VICTORY = 1;
    private final int LOSE = 2;    
    
    /**
     * niveau theorique ou le monstre peut apparaitre
     */
    private int level;
    
    /**
     * caractere du Monster
     */
    final char CHARACTER = '.';

    /**
     * Constructeur vide de Monster
     */
    public Monster() {
        super();
    }


  
    /**
     * Constructeur de Monster
     * @param name nom du Monster
     * @param strength force du Monster
     * @param gold Gold du Monster
     * @param level niveau min du Monster
     */
    public Monster(String name, int strength, int gold, int level) {
        super();
        this.setStrength(strength);
        this.setName(name);
        this.setGold(gold);
        this.level = level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
    
    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }

    /**
     * Permet de faire le Combat entre le monster et le Player
     * @param player le joueur
     * @return le message de combat
     */
    public Action action(Player player) {
        Action res = null;
        
        Random rand = new Random();
        int chance = rand.nextInt(100);
        
        double valeurmin = (player.getStrength() + this.getStrength());
        valeurmin = player.getStrength()/valeurmin;
        
        int proba =(int) (valeurmin*100);
        if (chance <= proba) {
            
            int goldNow = player.getGold()+this.getGold();
            player.setGold(goldNow) ;
            res = new Action(VICTORY , "You have killed "+this.getName()+" ("+ this.getStrength()+" strength). You looted "+this.getGold()+ "golds.");
        }
        else 
        {
            res = new Action(LOSE, "You have died from "+this.getName()+" ("+this.getStrength()+" strength)");
        }
        return res;
    }


}


