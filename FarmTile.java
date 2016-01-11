import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class FarmTile {
	
	int[] loc;
	Farm farm;
	int amount;
	String name;
	Tile ttype;
	int sicknessLevel
	
	public FarmTile(Farm farm, Tile ttype) {
		this.farm = farm;
		this.amount = -1;
		this.name = this.type;
		this.ttype = Tile.DIRT;
	}

	public int[] getLoc() {
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
		farm.rapture();
	}
	
	public int returnAmount() {
		return amount;
	}

	public void increaseThings() {

	}

	public Boolean equals(FarmTile other) {
		if (other.name.equals(this.name)) {
			return true;
		} else {
			return false;
		}
	}
}