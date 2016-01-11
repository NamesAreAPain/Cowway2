import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class FlyingCow extends Cow {

	private int[] dimensions;

	public FlyingCow(Farm farm, Tile ttype) throws FileNotFoundException {
		super(farm, ttype);
		this.name = Phrase.ADJECTIVE.get() + Phrase.NAME.get() + "the Flying Cow";
		this.ttype = Tile.FLYINGCOW;
	}

	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}

	public void doStuffForAnHour(int hour) {
		increaseThings();
		
		dimensions = farm.getDimensions();
		int[] loc1 = {random(rand, 0, dimensions[0]), random(rand, 0, dimensions[1])}



		if (direct1.go(loc).getThing().getType().equals("Grass")) {
			this.hunger -= direct1.go(loc).getThing().returnAmount();
			this.sicknessLevel += direct1.go(loc).getThing().returnSickness();
			moveThing(this, direct1);
		} else {
			moveThing(this, direct1);
		}
	}
}