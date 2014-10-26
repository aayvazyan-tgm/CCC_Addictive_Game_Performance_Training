package pathfinding.core.astar;

import pathfinding.core.Location;

public interface SortedLocationList {
	
	public void add(Location location);
	
	public Location getNext();
	
	public boolean hasNext();

}
