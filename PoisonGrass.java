import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class PoisonGrass extends Grass {

	public PoisonGrass(Farm farm, Tile ttype) {//constructor with same arguments
		super(farm, ttype);
		try {
			this.name = Phrase.ADJECTIVE.get() + " Poison Grass";
		} catch(FileNotFoundException e) {}
		this.ttype = Tile.POISONGRASS;
	}

	public void increaseThings() {//increases all the things
		this.amount += 2;
		this.sicknessLevel = this.amount;
	}
}