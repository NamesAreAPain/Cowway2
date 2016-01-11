import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class Grass extends FarmTile {
	
	private String name;
	private int sickness;

	public Grass(Farm farm, String type) {
		this.name = Phrase.ADJECTIVE.get() + "the Grass";
		this.ttype = Tile.GRASS;
	}
	
	public void increaseThings() {//increases things every hour
		this.quantity++;
		this.sickness = 0;
	}

	public void doStuffEveryHour(int hour) {
		increaseThings();
	}

	public int returnSickness() {
		returnSickness;
	}
}