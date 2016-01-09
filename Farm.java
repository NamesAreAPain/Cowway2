public enum Dir{
	NORTH (-1,0), SOUTH (1,0), EAST (0,1), WEST (-1,0)
	
	private final int deltaY;
	private final int deltaX;
	
	Dir(int dY, int dX){
		this.deltaY = dY;
		this.deltaX = dX;
	}
	
	int[] go(int[] loc0){
		int[] loc1 = new int[2];
		loc1[0] = loc0[0] + deltaY;
		loc1[1] = loc0[1] + deltaX;
		return loc1;
	}
}

public class Farm{
	private FarmTile[][] farmmap;
	private ArrayList<FarmTile> tilelist;
	private int[] dimensions;
	private String name;
	
	public Farm(int[]size){
		this.farmmap = new FarmTile[size[0]][size[1]];
		farmmap.fill(null);
		this.name = "The " + Phrase.ADJECTIVE.get() + " " + Phrase.NOUN.get(); 
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
	
	public FarmTile getThing(int[] loc){
		return farmmap[loc[0]][loc[1]];
	}
	
	public int[] getLocation(FarmTile thing){ //HARDERST PART OF ENTIRE PROJECT, HANDS DOWN. IMPOSSIBLE TO DO WELL, HARD TO DO AT ALL.
		y = 0;
		x = 0;
		for(int i = 0; i < dimensions[0]; i++){
			if(Arrays.asList(farmmap[i]).contains(thing)){
				y= i;
				break;
			}
		}
		x = Arrays.asList(farmmap[y]).indexOf(thing);
		int[] out = {y,x};
		return out;
	}
	
	public void setThing(FarmTile thing, int y, int x){
		farmmap[y][x] = thing;
	}
	
	public void setThing(FarmTile thing, int[] loc){
		farmmap[loc[0]][loc[1]] = thing;
	}
	
	
	public boolean isOpenTile(int y, int x){
		if( (y < dimensions[0]-1) && (x < dimensions[1]-1) && (getTile(y,x).getType().equals("Grass") || getTile(y,x) == null) ){
			return true;
		}
		return false;
	}
	
	public boolean isOpenTile(int[] loc){
		if( (loc[0] < dimensions[0]-1) && (loc[1] < dimensions[1]-1) && (getTile(loc).getType().equals("Grass") || getTile(loc) == null) ){
			return true;
		}
		return false;
	}
	
	
	public boolean moveThing(FarmTile thing,Dir direction){
		int[] loc0 = getLocation(thing);
		int[] loc1 = direction.go(loc0);
		if(!isOpenTile(loc1)) return false;
		setThing(thing, loc1);
		setThing(null, loc0);
		return true;
	}

	
	
}