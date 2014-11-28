package model;

import java.util.ArrayList;

/**
 * Classe pere de toutes les strategies du Game ,les strategies permettent au Game de créer l'arborescence des rooms
 * selon l'OPtionData
 * @author Dinar
 */
public interface IStrategy {

    public abstract void creationRoom(Room r);

    public abstract Cell creationCell(Room r);

    public abstract ArrayList<Room> createArborescence();

    /**
     * @return le nom de la strategie
     */
    public abstract String toString();
}
