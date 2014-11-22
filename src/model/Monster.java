package model;

import controller.Game;

import java.util.Random;
/**
 * La classe Monster d�finie tous les monstres que le joueur va rencontrer
 * Ils h�ritent de la classe Character
 * @author Dinar
 */
public class Monster extends Character {

    private int level;
    
    //constante de valeurs entre Game et action
    private final int NORMAL = 0 ;
    private final int VICTORY = 1;
    private final int LOSE = 2;
    
    
    final char CHARACTER = '.';

    public Monster() {
        super();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

  

    public Monster(String name, int strength, int gold, int level) {
        super();
        this.setStrength(strength);
        this.setName(name);
        this.setGold(gold);
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
            res = new Action(VICTORY , "Vous avez battu "+this.getName()+" de force "+ this.getStrength()+". Vous recevez "+this.getGold()+ "pi�ces d'or.");
        }
        else 
        {
            res = new Action(LOSE, "Vous avez perdu contre "+this.getName()+" de force "+this.getStrength()+". Vous recevez "+this.getGold() +"pi�ces d'or.");
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


