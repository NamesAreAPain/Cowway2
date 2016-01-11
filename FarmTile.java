import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class FarmTile {
	
	private int[] loc;
	private Farm farm;
	private String type;
	private int amount;
	private String name;
	private Tile ttype;
	
	public FarmTile(Farm farm, String type) {
		this.farm = farm;
		this.type = type;
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