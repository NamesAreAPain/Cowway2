import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class Grass extends FarmTile {
	
	String name;

	public Grass(Farm farm, Tile ttype) {//constructor with arguments like the super
		super(farm, ttype);
		try {
			this.name = Phrase.ADJECTIVE.get() + " Grass";
		} catch(FileNotFoundException e) {}
		this.ttype = Tile.GRASS;
		this.amount = 1;
	}
	
	public void increaseThings() {//increases things every hour
		this.amount++;
		this.sicknessLevel = 0;
	}

	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}

	public void spreadGrass() {
		Random rand = new Random();
		Dir direct = null;
		int spread = random(rand, 1, 4);
		switch(spread) {
			case 2: direct = Dir.EAST; break;
			case 3: direct = Dir.SOUTH; break;
			case 4: direct = Dir.WEST; break;
			case 1: 
			default: direct = Dir.NORTH; break;
		}

		int spreads = (int) (1000*this.amount);
		int checks = random(rand, 1, 100);
		if (spreads > checks) {
			if (getTileType(farm.getThing(direct.go(getLoc()))).equals(Tile.DIRT)) {
				farm.setThing(new Grass(farm,this.ttype), direct.go(getLoc()));	
			}
		}
	}

	public Tile getTileType(FarmTile aa){
		if( aa == null) return Tile.DIRT;
		return aa.getTType();
	}

	public void doStuffForAnHour(int hour) {
		increaseThings();
		spreadGrass();
	}
}