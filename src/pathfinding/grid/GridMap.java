package pathfinding.grid;

import pathfinding.grid.util.GridDouble;

import pathfinding.core.Map;

public class GridMap extends GridDouble implements Map{

	public static final int WALL = -1;
	
	private final double minimumValue = 0.01;
	
	public GridMap(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void set(int x, int y, double value){
		if(value == WALL){
			super.set(x, y, value);
		}else{
			if(value < minimumValue){
				value = minimumValue;
			}
			super.set(x, y, value);
		}
	}
	
	@Override
	public void reset(double value){
		if(value == WALL){
			super.reset(value);
		}else{
			if(value < minimumValue){
				value = minimumValue;
			}
			super.reset(value);
		}
	}

}
