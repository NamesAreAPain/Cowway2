import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class Dirt extends FarmTile {
	
	String name;

	public Dirt(Farm farm, Tile ttype) {
		super(farm, ttype);
		try {
			this.name = Phrase.ADJECTIVE.get() + " Dirt";
		} catch(FileNotFoundException e) {}
		this.ttype = Tile.DIRT;
	}

}