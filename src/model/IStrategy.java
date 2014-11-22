package model;

import java.util.ArrayList;
/**
 * Classe pere de toutes les strategies du Game ,les strategies permettent au Game de créer l'arborescence des rooms 
 * selon 
 */
public interface IStrategy {
    
    public abstract void CreationRoom(Room r);

    public abstract Cell CreationCell(Room r);
    
    public abstract ArrayList<Room> CreateArborescence();
}
