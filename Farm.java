import java.util.Scanner; 
import java.util.*; 
import java.io.*;


public class Farm{ //farm has an array of FarmTiles
	private FarmTile[][] farmmap; //the actual meat of the class
	private ArrayList<FarmTile> tilelist; //an index of FarmTiles
	private int[] dimensions; //dimensions of the farm , in form (y,x) beacasue that's how arrays print
	private String name; //the name
	private World world; //what world are we in?
	
	
	public Farm(int[]size,World world) throws FileNotFoundException{
		this.farmmap = new FarmTile[size[0]][size[1]]; //founds the farm
		this.name = "The " + Phrase.ADJECTIVE.get() + " " + Phrase.LETTER.get() + " " + Phrase.NOUN.get(); //names the farm using Phrase
		this.dimensions = size; //sets dimensions;
		
		//bughunting
		System.out.println(Arrays.toString(dimensions));
		
		this.tilelist = new ArrayList<FarmTile>(); //starts the list
		for(int i = 0; i < dimensions[0]; i++){ //all tiles 
			for(int j = 0; j < dimensions[1]; j++){
				farmmap[i][j] = aTile();
				tilelist.add(farmmap[i][j]);
				
			}
		}
		this.world = world; //the world we're in
		
	}
	
	public FarmTile[][] getMap(){ //the array of all the animals
		return farmmap;
	}
	
	public int[] getDimensions() { //gets the dimensions 
		return this.dimensions;
	}
	
	public void tick(){ //ticks the farm, by telling all the animals to do their thing
		for(FarmTile x: tilelist){
			x.doStuffForAnHour(world.whatTimeOfDay());
		}
	}
	
	public void Genesis(){ //no longer really used for anything
		
	}
	
	public FarmTile aTile(){ //chooses a random tile
		Random rand = new Random();
		int i = random(rand,1,15);
		switch(i){
			case 1 :
			case 2 :
			case 3 : return(new Cow(this,Tile.COW));
			case 4 : return(new FlyingCow(this,Tile.FLYINGCOW));
			case 5 : return(new NocturnalCow(this,Tile.NOCTURNALCOW));
			case 6 :
			case 7 :
			case 8 :
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
			case 9 : return(new Grass(this,Tile.GRASS));
			case 10: return(new PoisonGrass(this,Tile.POISONGRASS));
		} 
		return(new Dirt(this,Tile.DIRT));
	}
	
	public String getName(){ //get the name of the farm
		return name;
	}
	
	public int howMuchGrass(){ //how much grass? pretty self explanatory
		int grass = 0;
		for(FarmTile y : tilelist){
			if(y.getTType() == Tile.GRASS){
				grass++;
			}
		}
		return grass;
	}
	
	public int howManyCows(){ //how many cows
		int cows = 0;
		try {
		for(FarmTile y : tilelist){
			if(y.getTType() == Tile.COW || y.getTType() == Tile.FLYINGCOW || y.getTType() == Tile.FLYINGCOW ){
				cows++;
			}
		}
		} catch (NullPointerException e) {
			
		}
		return cows;
	}
	
	public FarmTile getThing(int y,int x){ //gets a thing at a location
		return farmmap[y][x];
	}
	
	public FarmTile getThing(int[] loc){ //gets a thing at a location (with an array input)
		return farmmap[loc[0]][loc[1]];
	}
	
	public int[] getLocation(FarmTile thing){ //HARDERST PART OF ENTIRE PROJECT, HANDS DOWN. IMPOSSIBLE TO DO WELL, HARD TO DO AT ALL.
		//finds the location of the damn thing
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
	
	public void setThing(FarmTile thing, int y, int x){ //sets the location to the thing
		farmmap[y][x] = thing;
	}
	
	public void setThing(FarmTile thing, int[] loc){ //see above
		farmmap[loc[0]][loc[1]] = thing;
	}
	
	
	public boolean isOpenTile(int y, int x){ //is the tile available to be moved to by a cow?
		if( (y < dimensions[0]-1) && (x < dimensions[1]-1) && (getThing(y,x).getTType() == Tile.GRASS || getThing(y,x).getTType() == Tile.DIRT || getThing(y,x).getTType() == Tile.POISONGRASS) ){
			return true;
		}
		return false;
	}
	
	public boolean isOpenTile(int[] loc){ //same thing
		if( (loc[0] < dimensions[0]-1) && (loc[1] < dimensions[1]-1) && (getThing(loc).getTType() == Tile.GRASS || getThing(loc).getTType() == Tile.DIRT || getThing(loc).getTType() == Tile.POISONGRASS) ){
			return true;
		}
		return false;
	}
	
	
	public Tile getTileTypeAt(int[] loc){
		if(getThing(loc) == null) return Tile.DIRT;
		return getThing(loc).getTType();
	}
	
	public boolean moveThing(FarmTile thing, Dir direction){ //moves the thing in a cardinal direction
		int[] loc0 = getLocation(thing);
		int[] loc1 = direction.go(loc0);
		if(!isOpenTile(loc1)) return false;
		setThing(thing, loc1);
		setThing(new Dirt(this,Tile.DIRT), loc0);
		return true;
	}
	
	public boolean moveThing(FarmTile thing, int[] loc){ //moves the thing to given spot (for flying cow)
		int[] loc0 = getLocation(thing);
		int[] loc1 = loc;
		if(!isOpenTile(loc1)) return false;
		setThing(thing, loc1);
		setThing(new Dirt(this,Tile.DIRT), loc0);
		return true;
	}
	
	public void rapture(FarmTile thing){ //removes thing, replacing ground with dirt;
		setThing(new Dirt(this,Tile.DIRT), this.getLocation(thing));
		tilelist.remove(thing);
	}
	
	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
	
	public World getWorld(){ //what world are we in?
		return world;
	}
}