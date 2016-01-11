import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class Cow extends FarmTile {
	
	private String name;
	private int hunger;
	private int age;
	private int sicknessLevel;

	public Cow() {
		this.name = Phrase.ADJECTIVE.get() + Phrase.NAME.get() + "the Cow";
	}

	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
	
	public void doStuffForAnHour(int hour) {
		increaseThings();
		if (hour < 19 || hour > 5) {
			Random rand = new Random();
			int direct = random(rand, 1, 4);
			Dir direct1 = null;
			if (direct == 1) {
				//north
				direct1 = NORTH;
			} else if (direct == 2) {
				//east
				direct1 = EAST;
			} else if (direct == 3) {
				//south
				direct1 = SOUTH;
			} else if (direct == 4) {
				//west
				direct1 = WEST;
			}
			if (direct1.go(loc).getThing().getType().equals("Grass")) {
				this.hunger -= direct1.go(loc).getThing().returnAmount();
				this.sicknessLevel += direct1.go(loc).getThing().returnSickness();
				moveThing(this, direct1);
			} else {
				moveThing(this, direct1);
			}
		}
	}

	public void increaseThings() {
		//increases things every hour
		this.hunger += 2;
		this.age++;
	}

	public int returnAmount() {
		return amount;
	}
}