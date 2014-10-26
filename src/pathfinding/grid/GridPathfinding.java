package pathfinding.grid;

import pathfinding.grid.astar.GridAstar;
import pathfinding.grid.astar.GridHeuristic;
import pathfinding.grid.astar.GridHeuristicManathan;
import pathfinding.core.Location;
import pathfinding.core.Map;
import pathfinding.core.Pathfinding;

public class GridPathfinding implements Pathfinding{

	GridAstar astar;
	GridHeuristic heuristic;
	
	public GridPathfinding(){
		heuristic = new GridHeuristicManathan();
	}
	
	@Override
	public GridPath getPath(Location s, Location e, Map m) {
		GridLocation start = (GridLocation)s;
		GridLocation end = (GridLocation)e;
		GridMap map = (GridMap)m;
		
		astar = new GridAstar(start, end, map, heuristic);
		
		return astar.getPath();
	}

}
