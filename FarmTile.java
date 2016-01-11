import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class FarmTile {
	
	private int[] loc;
	private Farm farm;
	private String type;
	int amount;
	String name;
	
	public FarmTile(Farm farm, String type) {
		this.farm = farm;
		this.type = type;
		this.amount = -1;
		this.name = this.type;
	}

	public int[] getLoc() {
		return loc;
	}
	
	public String getType() {
		return " ";
	}
	
	public void doStuffForAnHour(int hour) {
		
	}
	
	public void rapture(){
		
	}
	
	public int returnAmount() {

	}

	public int returnSickness() {

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