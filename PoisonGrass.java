import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class PoisonGrass extends Grass {

	public PoisonGrass(Farm farm, Tile ttype) {
		super(farm, ttype);
		this.name = Phrase.ADJECTIVE.get() + " Poison Grass";
		this.ttype = Tile.POISONGRASS;
	}

	public void increaseThings() {
		this.amount += 2;
		this.sickness = this.amount;
	}
}