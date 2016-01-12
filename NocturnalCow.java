import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class NocturnalCow extends Cow {

	public NocturnalCow(Farm farm, Tile ttype) {//constructor with same arguments as super
		super(farm, ttype);
		this.farm = farm;
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

			moveCow();

			int randInt = random(rand, 1, 100);
			int sick = (int) (0.000001*getAge()*getSickness());
			if (this.hunger == 100 || this.age == 90001 || sick > randInt) {//checks for death
				rapture();
			}
		}
	}	
}