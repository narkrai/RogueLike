package controller;

import model.Monster;

public  class MonsterFactory {
   
    private static MonsterType[] ListMonster = {
        new MonsterType("Dragon",50, 100, 300, 500, 0),
        new MonsterType("Troll",10, 20, 5, 50, -5),
        new MonsterType("ArcaysXXX", 1, 250, 1, 10, -10)
    };

    public  static Monster buildMonster() {
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
        
        
        public MonsterType(String monsterName,int minStrength,int maxStrength,int minTreasure,int maxTreasure, int level) {
            this.name = monsterName;
            this.minStrength = minStrength;
            this.maxStrength = maxStrength;
            this.minGold = minTreasure;
            this.maxGold = maxTreasure;
            this.levelMin = level;
        }
        
        public Monster create() {
            int force = (int)( Math.random()*( this.maxStrength - this.minStrength + 1 ) ) + this.minStrength;
            int treasure=(int)( Math.random()*( this.maxGold - this.minGold + 1 ) ) + this.minGold;
            return  new Monster(this.name,force,treasure);
        }
    }
}

