package model;

/**
 * Objet qui va contenir un score
 * @author Nicolas Nguyen
 */

public class HighScore implements Comparable<HighScore>{
    private     String      name;       // Nom du joueur
    private     int         score;      // Score du joueur
    
    /**
     * Constructeur de l'objet HighScore
     * @param name Nom du joueur
     * @param score Score
     */
    public HighScore(String name, int score) {
      this.name = name;
      this.score = score;
    }
    
    /**
     * Getter de Name
     * @return name Nom du joueur
     */
    public String getName() {
        return name;
    }
    
    /**
     * Getter du Score
     * @return score Score du joueur
     */
    public int getScore() {
        return score;
    }

    /**
     * Methode pour comparer deux HighScore entre eux par leur score
     * @param h HighScore à comparer
     * @return -1 si inférieur, 1 si supérieur, 0 si egal
     */
    @Override
    public int compareTo(HighScore h) {
        if(score < h.score) 
            return -1;
        if(score > h.score) 
            return 1;
        return 0;
    }
    
    /**
     * Methode permettant d'avoir un string avec un HighScore
     * @return String "Nom ; Score"
     */
    public String toString() {
        return name+";"+score;
    }
}
