package model;

public class HighScore implements Comparable<HighScore>{
    private String name;
    private int score;

    public HighScore(String n, int c) {
      name = n;
      score = c;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(HighScore h) {
        if(score < h.score) 
            return -1;
        if(score > h.score) 
            return 1;
        return 0;
    }
    
    public String toString() {
        return name+";"+score;
    }
}
