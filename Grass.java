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
	}
	
	public void increaseThings() {//increases things every hour
		this.amount++;
		this.sicknessLevel = 0;
	}

	public void doStuffEveryHour(int hour) {
		increaseThings();
	}
}