package model;

/**
 * CellUnit est le fils de Cell .
 * Ces Cell sont contenus dans des Rooms et possedent un unique item
 * @author Dinar
 */
public class CellUnit extends Cell {

    /**
     * Item possed� par la Cell (peut etre null)
     */
    private Item item;

    /**
     * Constructeur vide de CellUnit
     */
    public CellUnit() {


    }

    /**
     * Fonction permettant de choisir le caractere � afficher
     * selon le Boolean this.isDiscovered la CellUnit affiche soit le caractere du pere, soit de l'objet
     *
     * @return le caractere a affich�
     */
    public char getCHARACTER() {

        char res;

        if (this.isDiscovered()) {

            if (this.getItem() != null) {
                res = this.getItem().getCharacter();

            } else {
                res = '.';
            }

        } else {
            res = super.getCHARACTER();
        }

        return res;
    }


    /**
     * Fonction permettant de supprimer l'item de la CellUnit
     */
    public void deleteItem() {
        this.item = null;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    /**
     * Fonction override permettant de connaitre l'�tage de la CellUnit
     * @return numero d'etage (de 0 � un nombre n�gatif)
     */
    @Override
    public int numeroEtage() {
        return super.getConteneur().numeroEtage();
    }

    /**
     * Fonction override permettant de connaitre le nombre de Gold de la CellUnit
     * @return nombre de Gold de la CellUnit (sans les Gold des Monsters)
     */
    @Override
    public int getTotalGold() {
        int res = 0;
        if (this.item instanceof Chest) {
            Chest t = (Chest) this.item;
            res = t.getGold();
        }
        return res;
    }

    /**
     * Fonction override permettant de connaitre le nombre Monster de la CellUnit
     * @return nombre de Monster de la CellUnit (0 ou 1)
     */
    @Override
    public int getTotalMonster() {
        int i = 0;

        if (this.item instanceof Monster) {
            i = 1;
        }
        return i;
    }

    /**
     * Fonction abstraite permettant de savoir le nombre de Item "Sortie" qu'une CellUnit poss�de
     *
     *
     * @return Nombre de sortie de la CellUnit (0 ou 1)
     */
    @Override
    public int aUneSortie() {

        int res = 0;
        if (this.getItem() instanceof Exit) {
            res = 1;
        }


        return res;
    }
}
