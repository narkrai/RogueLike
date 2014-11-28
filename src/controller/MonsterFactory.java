package controller;

import model.Monster;

/**
 * Classe qui va cr�er des monstres
 */

public  class MonsterFactory {
    
    private  static MonsterType[] ListMonster = {
        new MonsterType("Dragon", 25, 50, 300, 500, 0),
        new MonsterType("Orc",10, 20, 50,100, -2),
        new MonsterType("Troll",1, 10, 5, 50, -5),
        new MonsterType("ArcaysXXX", 1, 100, 1, 1000, -10),      // Cette homme est un gros rageux, des fois
        new MonsterType("Karim Dinar", 10, 50, 1, 125, -15)
    };
    

    public static Monster buildMonster() {
        int count = ListMonster.length;
        int res =  (int)(Math.random()*count);
        MonsterType monstretype = ListMonster[res];
       return monstretype.create();
    }

    public static class MonsterType {
        private String name;
        private int minStrength;
        private int maxStrength;
        private int minGold;
        private int maxGold;
        private int levelMin;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setMinStrength(int minStrength) {
            this.minStrength = minStrength;
        }

        public int getMinStrength() {
            return minStrength;
        }

        public void setMaxStrength(int maxStrength) {
            this.maxStrength = maxStrength;
        }

        public int getMaxStrength() {
            return maxStrength;
        }

        public void setMinGold(int minGold) {
            this.minGold = minGold;
        }

        public int getMinGold() {
            return minGold;
        }

        public void setMaxGold(int maxGold) {
            this.maxGold = maxGold;
        }

        public int getMaxGold() {
            return maxGold;
        }

        public void setLevelMin(int levelMin) {
            this.levelMin = levelMin;
        }

        public int getLevelMin() {
            return levelMin;
        }
        
        public MonsterType(String monsterName,int minStrength,int maxStrength,int minTreasure,int maxTreasure, int level) {
            this.name = monsterName;
            this.minStrength = minStrength;
            this.maxStrength = maxStrength;
            this.minGold = minTreasure;
            this.maxGold = maxTreasure;
            this.levelMin = level;
        }
        
        public Monster create() {
            int force = (int)( Math.random() *(getMaxStrength() - getMinStrength()) ) + getMinStrength();
            int treasure=(int)( Math.random()*( getMaxGold() - getMinGold()) ) + getMinGold();
            int lvl =( int)((Math.random()*(getLevelMin()))+getLevelMin());
            return  new Monster(getName(),force,treasure,lvl);
        }
    }
}

