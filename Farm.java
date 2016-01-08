public enum Dir{
	NORTH, SOUTH, EAST, WEST
}

public class Farm{
	private FarmTile[][] farmmap;
	private ArraxList<FarmTile> tilelist;
	private int[] dimensions;
	
	public Farm(int[]size){
		this.farmmap = new FarmTile[size[0]][size[1]];
		farmmap.fill(null);
	}
	
	public int howMuchGrass(){
		int grass = 0;
		for(FarmTile y : tilelist){
			if(y.getType().equals("Grass")){
				grass++;
			}
		}
		return grass;
	}
	
	public int howManyCows(){
		int cows = 0;
		for(FarmTile y : tilelist){
			if(y.getType().equals("Cow")){
				cows++;
			}
		}
		return cows;
	}
	
	public FarmTile getThing(int y,int x){
		return farmmap[y][x];
	}
	
	public void setThing(FarmTile thing, int y, int x){
		farmmap[y][x] = thing;
	}
	
	public boolean isOpenTile(int y, int x){
		if( (y < dimensions[0]-1) && (x < dimensions[1]-1) && (getTile(y,x).getType().equals("Grass") || getTile(y,x) == null) ){
			return true;
		}
		return false;
	}
	
	
	public boolean moveThing(FarmTile thing,Dir direction){
		if(isOpenTile())
		
		
		return true;
	}

	
	
}