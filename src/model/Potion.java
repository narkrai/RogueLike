package model;


/**
 * Classe qui gere les potions que le Player va gouter dans ces aventures epiques
 * Fils de Tresaure
 * @author Dinar
 */
public class Potion extends Treasure {

    private int strength;
    final char CHARACTER = 'p';

    public Potion(int strength) {
        super();
        this.setStrength(strength);
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }

    /**
     * Permet de faire gagner ou perdre de la force du Player
     * @param player le joueur
     * @return le message Action
     */
    @Override
    public Action action(Player p) {
        p.setStrength(p.getStrength() + this.getStrength());

        String message = "";
        if (this.strength < 0) {
            message = "Vous avez bu une potion toxique  pour votre sante. Vous perdez" + (-1 * this.strength) + ".";
        } else {
            message = "Vous avez bu une potion benefique pour votre force .Vous gagnez  " + this.strength + ".";
        }
        return new Action(0, message);
    }

    @Override
    public char getCHARACTER() {

        return this.CHARACTER;
    }
}
