import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class FlyingCow extends Cow {

	private int[] dimensions;

	public FlyingCow(Farm farm, Tile ttype) {//constructor with same arguments as super
		super(farm, ttype);
		try {
			this.name = Phrase.ADJECTIVE.get() + Phrase.NAME.get() + "the Flying Cow";
		} catch(FileNotFoundException e) {}
		this.ttype = Tile.FLYINGCOW;
	}

	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}

	public void doStuffForAnHour(int hour) {//what the cow does every hour
		increaseThings();
		this.dimensions = farm.getDimensions();
		Random rand = new Random();
		int[] loc1 = {random(rand, 0, dimensions[0]), random(rand, 0, dimensions[1])};

		if (farm.getThing(loc1).getTType().equals(Tile.GRASS)) {
			this.hunger -= farm.getThing(loc1).returnAmount();
			this.sicknessLevel += farm.getThing(loc1).getSickness();
		}
		farm.moveThing(this, loc1);
	}
}