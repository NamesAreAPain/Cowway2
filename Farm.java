import java.util.Scanner; 
import java.util.*; 
import java.io.*;


public class Farm{
	private FarmTile[][] farmmap;
	private ArrayList<FarmTile> tilelist;
	private int[] dimensions;
	private String name;
	private World world;
	
	public Farm(int[]size,World world) throws FileNotFoundException{
		this.farmmap = new FarmTile[size[0]][size[1]];
		Arrays.fill(farmmap, null);
		this.name = "The " + Phrase.ADJECTIVE.get() + " " + Phrase.LETTER.get() + " " + Phrase.NOUN.get(); 
		this.world = world;
		this.dimensions = size;
	}
	
	public int[] getDimensions() {
		return dimensions;
	}

	public void tick(){
		for(FarmTile x: tileList){
			x.doStuffForAnHour(world.whatTimeOfDay());
		}
	}
	
	public void Genesis(){
		for(int i = 0; i < dimensions[0]; i++){
			for(int j = 0; j < dimensions[1]; j++){
				farmmap[i][j] = aTile();
				tilelist.add(farmmap[i][j]);
			}
		}
	}
	
	public FarmTile aTile(){
		Random rand = new Random();
		int i = random(rand,1,15);
		switch(i){
			case 1 :
			case 2 :
			case 3 : return(new Cow(this,"Cow"));
			case 4 : return(new FlyingCow(this,"Cow"));
			case 5 : return(new NocturnalCow(this,"Cow"));
			case 6 :
			case 7 :
			case 8 :
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
			case 9 : return(new Grass(this,"Grass"));
			case 10: return(new PoisonGrass(this,"Grass"));
		}
	}
	
	public String getName(){
		return name;
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
		try {
		for(FarmTile y : tilelist){
			if(y.getType().equals("Cow")){
				cows++;
			}
		}
		} catch (NullPointerException e) {
			
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
		int y = 0;
		int x = 0;
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
		if( (y < dimensions[0]-1) && (x < dimensions[1]-1) && (getThing(y,x).getType().equals("Grass") || getThing(y,x) == null) ){
			return true;
		}
		return false;
	}
	
	public boolean isOpenTile(int[] loc){
		if( (loc[0] < dimensions[0]-1) && (loc[1] < dimensions[1]-1) && (getThing(loc).getType().equals("Grass") || getThing(loc) == null) ){
			return true;
		}
		return false;
	}
	
	
	public boolean moveThing(FarmTile thing, Dir direction){
		int[] loc0 = getLocation(thing);
		int[] loc1 = direction.go(loc0);
		if(!isOpenTile(loc1)) return false;
		setThing(thing, loc1);
		setThing(null, loc0);
		return true;
	}
	
	public boolean moveThing(FarmTile thing, int[] loc){
		int[] loc0 = getLocation(thing);
		int[] loc1 = loc;
		if(!isOpenTile(loc1)) return false;
		setThing(thing, loc1);
		setThing(null, loc0);
		return true;
	}
	
	public World getWorld(){
		return world;
	}
}