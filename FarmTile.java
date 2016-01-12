import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class FarmTile {
	
	int[] loc;
	Farm farm;
	int amount;
	String name;
	Tile ttype;
	int sicknessLevel;
	
	public FarmTile(Farm farm, Tile ttype) {
		this.farm = farm;
		this.amount = 1;
		this.ttype = Tile.DIRT;
		this.loc = farm.getLocation(this);
	}

	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}

	public String getName() {
		
	}

	public int[] getLoc() {
		this.loc = farm.getLocation(this);
		return loc;
	}
	
	public String getType() {
		return " ";
	}
	
	public void doStuffForAnHour(int hour) {
		
	}
	
	public Tile getTType(){
		return ttype;
	}
	
	public void rapture(){
		farm.setThing(null, loc);
		farm.rapture(this);
	}
	
	public int returnAmount() {
		return amount;
	}

	public void increaseThings() {

	}

	public int getSickness() {
		return sicknessLevel;
	}

	public Boolean equals(FarmTile other) {
		if (other.name.equals(this.name)) {
			return true;
		} else {
			return false;
		}
	}
}