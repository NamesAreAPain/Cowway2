import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class NocturnalCow extends Cow {

	public NocturnalCow(Farm farm, Tile ttype) {//constructor with same arguments as super
		super(farm, ttype);
		try {
			this.name = Phrase.ADJECTIVE.get() + Phrase.NAME.get() + "the Nocturnal Cow";
		} catch(FileNotFoundException e) {}
		this.ttype = Tile.NOCTURNALCOW;
	}

	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}

	public void doStuffForAnHour(int hour) {//what the cow does every hour
		increaseThings();
		Random rand = new Random();
		if (hour < 6 || hour > 18) {
			int direct = random(rand, 1, 4);
			Dir direct1 = null;
			switch(direct) {
				case 2: direct1 = Dir.EAST;//cow go east
				case 3: direct1 = Dir.SOUTH;//cow go south
				case 4: direct1 = Dir. WEST;//cow go west
				case 1:
				default: direct1 = Dir.NORTH;//cow go north
			}

			if (farm.getThing(direct1.go(getLoc())).getTType().equals(Tile.GRASS)) {
				this.hunger -= farm.getThing(direct1.go(getLoc())).returnAmount();
				this.sicknessLevel += farm.getThing(direct1.go(getLoc())).getSickness();
				farm.moveThing(this, direct1);
			} else {
				farm.moveThing(this, direct1);
			}

			int randInt = random(rand, 1, 100);
			int sick = (int) (0.000001*getAge()*getSickness());
			if (this.hunger == 100 || this.age == 90001 || sick > randInt) {
				rapture();
			}
		}
	}	
}