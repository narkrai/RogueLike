package model;

import controller.MonsterFactory;

import java.util.ArrayList;
import java.util.Random;

import view.IHM_Welcome;
/**
 * La Classe Nice est une strategie inspiré de Idiot mais (( très ) nettement amelioré
 *
 * *Les Room ont tous la  meme taille
 * *les Items sont placés aléatoirement
 * *les Room ont tous un unique pere
 * *Il n'y qu'une seule sortie
 * *La création du chemin gagnant  ( c'est-à-dire le chemin entre le Player et la Sortie) est fait en antériori
 * *Generation leger en temps de calcul
 * *Aucune astuce tel que le rajout de salle ( contrairement à son compère Idiot)
 * @author Dinar
 */
public class Nice implements IStrategy {
    public Nice() {
        super();
    }


    private Room PeredeTous;

    private int etageCourant;
    private int roomCreated = 0;
    private boolean cheminSortant = false;

    @Override
    public void CreationRoom(Room roomPere) {
        OptionData opdataCurrent = OptionData.getInstance();



        Cell cellCreated;

        roomPere.setContenus(new ArrayList<Cell>());
        Random rand = new Random();
        int randX;
        int randY;

        roomPere.setTailleX(opdataCurrent.getTailleXRoom());
        roomPere.setTailleY(opdataCurrent.getTailleYRoom());

        //Creation du joueur dans la Room pere de tous
        if (roomPere.getConteneur() == null) {

            randX = rand.nextInt(roomPere.getTailleX());
            randY = rand.nextInt(roomPere.getTailleY());

            CellUnit cUnitPlayer = new CellUnit();

            cUnitPlayer.setPositionX(randX);
            cUnitPlayer.setPositionY(randY);
            cUnitPlayer.setConteneur(roomPere);
            roomPere.AjoutCell(cUnitPlayer);

            cUnitPlayer.setItem(Player.getInstance());


        }

        //Construction du chemin gagnant ou de la sortie 

        if (!(this.etageCourant == 0)) {


            this.etageCourant--;


            boolean roomIsPlaced = false;
            while (!roomIsPlaced) {

                randX = rand.nextInt(roomPere.getTailleX());
                randY = rand.nextInt(roomPere.getTailleY());

                if (roomPere.getCell(randX, randY) == null) {
                    cellCreated = this.MakeRoom(roomPere);
                    cellCreated.setPositionX(randX);
                    cellCreated.setPositionY(randY);
                    roomPere.AjoutCell(cellCreated);
                    roomIsPlaced = true;

                }
            }
        }
        else if ( !this.cheminSortant && (roomPere.numeroEtage() == 0)) {
            
                            
            boolean exitIsPlaced = false;
            while (!exitIsPlaced) {

                randX = rand.nextInt(roomPere.getTailleX());
                randY = rand.nextInt(roomPere.getTailleY());

                if (roomPere.getCell(randX, randY) == null) {
                    CellUnit cUCreated = new CellUnit(); 
                    cUCreated.setPositionX(randX);
                    cUCreated.setPositionY(randY);
                    roomPere.AjoutCell(cUCreated);
                    cUCreated.setItem(new Exit());
                    
                    
                    exitIsPlaced = true;
                    
                    this.cheminSortant = true;

                }

            }
            
            
        }
        
        
        
        


        //creation de escalier descendant
        while (!roomPere.aCheminVersPere()) {
            randX = rand.nextInt(roomPere.getTailleX());
            randY = rand.nextInt(roomPere.getTailleY());


            if (roomPere.getCell(randX, randY) == null) {

                CellUnit cC = new CellUnit();

                cC.setPositionX(randX);
                cC.setPositionY(randY);
                cC.setConteneur(roomPere);
                roomPere.AjoutCell(cC);

                Stair st = new Stair(roomPere);
                cC.setItem(st);

                System.out.println("Chemin vers pere crée");
            }


        }


        //Creation de la salle selon sa taille
        for (int x = 0; x < roomPere.getTailleX(); x++) {
            for (int y = 0; y < roomPere.getTailleY(); y++) {


                //des cases sont deja crées il ne faut pas les recréer
                if (roomPere.getCell(x, y) == null) {

                    cellCreated = CreationCell(roomPere);
                    cellCreated.setPositionX(x);
                    cellCreated.setPositionY(y);
                    cellCreated.setConteneur(roomPere);
                    roomPere.AjoutCell(cellCreated);
                    System.out.println(x + " , " + y);
                }
            }

        }


        System.out.println("Room terminé etage" + roomPere.numeroEtage() + " et a un chemin vers pere");


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


    @Override
    public ArrayList<Room> CreateArborescence() {

        roomCreated = 0;
        cheminSortant = false;
        ArrayList<Room> res = new ArrayList<Room>();

        this.etageCourant = OptionData.getInstance().getDepthmax();

        PeredeTous = new Room(this);

        for (Room rF : PeredeTous.avoirLesRoomsFils()) {
            res.add(rF);
        }
        res.add(PeredeTous);


        return res;
    }


    public String toString() {
        return "Nice (recommandé)";
    }

    public static void main(String[] args) {

       IStrategy s = new Nice();
       
       s.CreateArborescence();
       
       
       
    }

}
