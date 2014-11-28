package model;

import controller.Game;
import controller.MonsterFactory;

import java.io.Console;

import java.util.ArrayList;

import java.util.Random;

import view.IHM_GameUI;

/**
 * La Classe idiot est une strategie envisable pour la création de l'arborescence de Room à partir de l'OptionData
 *
 * *Les Room ont tous la  meme taille
 * *les Items sont placés aléatoirement
 * *les Room ont tous un unique pere
 * *Il n'y qu'une seule sortie
 * *La création du chemin gagnant  ( c'est-à-dire le chemin entre le Player et la Sortie) est fait à posteori
 * *Generation lourde en temps de calcul
 * On triche sur le nombre de salles si il n'y a pas de chemin gagnant
 * @author Dinar
 */
public class Idiot implements IStrategy {

    /**
     * Nombre de room crée total
     */
    private int roomCreated = 0;

    /**
     * Construteur vide de la classe
     */
    public Idiot() {
        super();

    }

    /**
     * Cette methode permet de creer les cellules de la room ainsi que ces Room fils selon l'OptionData
     * il cree egalement un escalier descendant si la room a un pere et le joueur dans la Room pere
     * @param Room r room à creer
     *
     */
    @Override
    public void CreationRoom(Room roomPere) {

        OptionData opdataCurrent = OptionData.getInstance();

        Cell cellCreated;
        Cell cellChosen;

        Random rand = new Random();
        int randX;
        int randY;

        roomPere.setContenus(new ArrayList<Cell>());

        roomPere.setTailleX(opdataCurrent.getTailleXRoom());
        roomPere.setTailleY(opdataCurrent.getTailleYRoom());


        //Creation de la salle selon sa taille
        for (int x = 0; x < roomPere.getTailleX(); x++) {
            for (int y = 0; y < roomPere.getTailleY(); y++) {

                cellCreated = CreationCell(roomPere);
                cellCreated.setPositionX(x);
                cellCreated.setPositionY(y);
                cellCreated.setConteneur(roomPere);
                roomPere.AjoutCell(cellCreated);
                System.out.println(x + " , " + y);

            }

        }


        //Creation d'un escalier descendant  vers le pere si la Room est un fils

        while (!roomPere.aCheminVersPere()) {
            randX = rand.nextInt(roomPere.getTailleX());
            randY = rand.nextInt(roomPere.getTailleY());

            cellChosen = roomPere.getCell(randX, randY);

            if (!(cellChosen instanceof Room)) {

                CellUnit cC = (CellUnit) cellChosen;


                Stair st = new Stair(roomPere);
                cC.setItem(st);
                System.out.println("Chemin vers pere crée");


            }


        }


        System.out.println("Room terminé etage" + roomPere.numeroEtage() + " et a un chemin vers pere");
    }

    /**
     *Cette fonction renvoit une CellUnit ou une Room selon l'OptionData
     * @param roomPere room parent
     * @return la Cell crée
     */
    public Cell CreationCell(Room roomPere) {

        OptionData opdataCurrent = OptionData.getInstance();


        Cell cellCreated;

        Random rand = new Random();
        int Random = rand.nextInt(100);
        // si la Room n'est pas  au dernier etage et que le nombre maximal de salle n'est pas depassé
        if (roomPere.numeroEtage() != 0 && roomPere.numberofRoom() < opdataCurrent.getDoormax() &&
            this.roomCreated < opdataCurrent.getRoomMax()) {
            //la Room a une certaine chance d'avoir une Room fils selon OptionData
            if (Random < opdataCurrent.getLadderLuck()) {

                System.out.println("Valeur du rand :" + Random);
                cellCreated = MakeRoom(roomPere);

            } else {
                cellCreated = MakeCellUnit();
                System.out.println("Nouvelle cell crée");
            }

        } else {
            System.out.println("Nouvelle cell crée");
            cellCreated = MakeCellUnit();
        }

        return cellCreated;
    }

    /**
     * Permet la creation d'une Room
     * @param pere la Room pere
     * @return un objet Room
     */
    private Room MakeRoom(Room pere) {


        Room res = new Room(this, pere);
        System.out.println("Nouvelle Room crée");

        this.roomCreated++;
        return res;


    }

    /**
     *Permet la création d'une CellUnit selon l'OptionData et de mettre un objet au hasard
     * @param pere La Room pere
     * @return un objet CellUnit
     */
    private CellUnit MakeCellUnit() {

        OptionData opdataCurrent = OptionData.getInstance();

        CellUnit res = new CellUnit();

        Random rand = new Random();
        int randomValue = rand.nextInt(100);

        if (randomValue <= opdataCurrent.getMonsterLuck() + opdataCurrent.getLadderLuck()) {

            res.setItem(MonsterFactory.buildMonster());

        } else if (opdataCurrent.getMonsterLuck() < randomValue &&
                   randomValue <=
                   opdataCurrent.getPotionLuck() + opdataCurrent.getMonsterLuck() + opdataCurrent.getLadderLuck()) {

            int randStrength;
            randStrength =
                (int) (opdataCurrent.getMinPowerPotion() +
                       (Math.random() * (opdataCurrent.getMaxPowerPotion() - opdataCurrent.getMinPowerPotion())));

            Potion p = new Potion(randStrength);

            res.setItem(p);
        } else if (opdataCurrent.getPotionLuck() < randomValue &&
                   randomValue <=
                   opdataCurrent.getPotionLuck() + opdataCurrent.getTreasureLuck() + opdataCurrent.getMonsterLuck() +
                   opdataCurrent.getLadderLuck()) {

            int randOr;
            randOr =
                (int) (opdataCurrent.getMinGoldTresaure() +
                       (Math.random() * opdataCurrent.getMaxGoldTresaure() - opdataCurrent.getMinGoldTresaure()));


            res.setItem(new Chest(randOr));

        } else {
            res.setItem(null);
        }


        return res;


    }

    /**
     * Cette fonction permet de creer un Room père et ses fils et de les mettre dans une liste
     * Cette methode cree egalement un objet sortie sur une des cases  d'une Room au niveau 0
     * @return la liste complete des Room
     */
    public ArrayList<Room> CreateArborescence() {


        int nbOld = OptionData.getInstance().getRoomMax();

        roomCreated = 0;

        int RandX;
        int RandY;
        Random rand = new Random();
        double Elu;


        // Room de Tous
        Room r = new Room(this);
        System.out.println("La room pere A ete correctement crée");
        ArrayList<Room> res = new ArrayList<Room>();

        //Tant que le jeu n'a pas de sortie on boucle
        while (r.aUneSortie() != 1) {
            res.clear();
            System.out.println("r.aUneSortie() " + r.aUneSortie());

            System.out.println("aUneSortie " + r.aUneSortie());

            for (Room rF : r.avoirLesRoomsFils()) {
                res.add(rF);
            }
            res.add(r);

            System.out.println("Liste iteration + 1");

            System.out.println("r.AvoirLeNiveauMinDesFils() " + r.AvoirLeNiveauMinDesFils());

            //On verifie d'abord si l'arborescence à bien une room sinon on recrée l'ensemble
            if (r.AvoirLeNiveauMinDesFils() == 0) {
                System.out.println("r.AvoirLeNiveauMinDesFils() " + r.AvoirLeNiveauMinDesFils());
                //Tant que le jeu n'a pas de sortie on boucle
                while (r.aUneSortie() != 1) {
                    for (Room a : res) {
                        //
                        System.out.println("a.numeroEtage() " + a.numeroEtage());
                        Elu = rand.nextDouble();

                        if (a.numeroEtage() == 0 && r.aUneSortie() != 1) {


                            while (r.aUneSortie() != 1) {
                                RandX = rand.nextInt(a.getTailleX());
                                RandY = rand.nextInt(a.getTailleY());

                                Cell c = a.getCell(RandX, RandY);

                                if (!(c instanceof Room)) {

                                    CellUnit cC = (CellUnit) c;


                                    Exit e = new Exit();
                                    cC.setItem(e);


                                }

                            }


                        }

                    }
                }

            }
            // il est possible qu'aucune Room soit à l'etage zero. Dans ce cas on prend une des Rooms les plus hautes et on la regenerer pour forcer l'apparition
            //de nouvelle Rooms
            else {

                /* r = new Room(this);*/

                System.out.println("JE BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOUUUUUUUUUUUUUUUUUUUUUUUCCCCCCCCCCCCCLLLLLLLLLLLLLLLLLLLLEEEEEEEEEEEEEE !!!");
                Room roomTaken = null;
                int i = 0;
                /*
             * Si le nombre de salle maximal est egal au nombre de salles effectif, on incremente le nombre de salle possible
             * (faute de givre , on se contente de merles)
             */
                if (this.roomCreated == OptionData.getInstance().getRoomMax()) {
                    OptionData.getInstance().setRoomMax(this.roomCreated + 1);
                }


                while (roomTaken == null) {
                    if (res.get(i).numeroEtage() == r.AvoirLeNiveauMinDesFils()) {


                        roomTaken = res.get(i);
                        System.out.println("Niveau de cette salle :" + roomTaken.numeroEtage());
                    }

                    i++;
                }
                if (roomTaken.getConteneur() == null) {
                    this.roomCreated = 0;
                    r = null;
                    r = new Room(this);
                    System.out.println("PPPniveau min pere = " + r.AvoirLeNiveauMinDesFils());
                } else {


                    roomTaken = new Room(this, roomTaken.getConteneur());
                    System.out.println("FFFniveau min pere = " + r.AvoirLeNiveauMinDesFils());
                }


            }
        }

        boolean playerIsPlaced = false;
        //et Puis enfin  Placement du Joueur dans la Room PERE de tous


        while (!playerIsPlaced) {


            RandX = rand.nextInt(r.getTailleX());
            RandY = rand.nextInt(r.getTailleY());

            Cell cellChosen = r.getCell(RandX, RandY);

            if (!(cellChosen instanceof Room)) {

                CellUnit cC = (CellUnit) cellChosen;

                if (!(cC.getItem() instanceof Stair) && !(cC.getItem() instanceof Exit)) {

                    cC.setItem(Player.getInstance());
                    playerIsPlaced = true;

                }


            }


        }

        //On remet la valeur initial du nombre de salle
        OptionData.getInstance().setRoomMax(nbOld);
        return res;


    }

    public String toString() {
        return "Idiot";
    }
}
