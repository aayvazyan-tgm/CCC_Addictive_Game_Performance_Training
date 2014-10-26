package pathfinding.grid.astar;

import pathfinding.grid.GridLocation;

public interface GridHeuristic {
	
	public double getDistance(int x, int y, GridLocation location);

}
