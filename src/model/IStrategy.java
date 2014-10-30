package model;

import java.util.ArrayList;

public interface IStrategy {
    
    public abstract Room CreationRoom(Room r);

    public abstract Cell CreationCell(Room r);
    
    public abstract ArrayList<Room> CreateArborescence();
}
