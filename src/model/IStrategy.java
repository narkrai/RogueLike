package model;

import java.util.ArrayList;

public interface IStrategy {
    
    public abstract void CreationRoom(Room r);

    public abstract Cell CreationCell(Room r, Cell c);
    
    //public abstract ArrayList<Room> CreateArborescence();
}
