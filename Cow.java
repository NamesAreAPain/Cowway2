import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class Cow extends FarmTile {
	//variables
	String name;
	int hunger;
	int age;
	Farm farm;

	public Cow(Farm farm, Tile ttype) {//Constructor with same arguments as super
		super(farm, ttype);
		this.farm = farm;
		try{
			this.name = Phrase.TITLE.get() + Phrase.NAME.get() + "the " + Phrase.ADJECTIVE.get() + " Cow";//Proper nameology
		} catch(FileNotFoundException e) {}
		this.ttype = Tile.COW;
	}

	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
	
	public void doStuffForAnHour(int hour) {//what the cow does every hour
		increaseThings();
		Random rand = new Random();
		if (hour < 19 || hour > 5) {

			moveCow();

			int randInt = random(rand, 1, 100);
			int sick = (int) (0.000001*this.age*this.sicknessLevel);
			if (this.hunger >= 100 || this.age >= 90001 || sick > randInt) {//check for death
				rapture();
				System.out.println("hahaha");
			}
		}
	}

	public void moveCow() {
		Random rand = new Random();
		int direct = random(rand, 1, 4);
		Dir direct1 = null;

		switch(direct) {//chooses the direction based off of a random number
			case 2: direct1 = Dir.EAST; break;
			case 3: direct1 = Dir.SOUTH; break;
			case 4: direct1 = Dir.WEST; break;
			case 1:
			default: direct1 = Dir.NORTH; break;
		}
	
		if(farm.isOpenTile(direct1.go(this.getLoc()))){
			if (farm.getTileTypeAt(direct1.go(this.getLoc())) == Tile.GRASS) {
				this.hunger -= farm.getThing(direct1.go(getLoc())).returnAmount();
				this.sicknessLevel += farm.getThing(direct1.go(getLoc())).getSickness();
				farm.moveThing(this, direct1);
			} else {
			farm.moveThing(this, direct1);
			}
		}
	}
	//returning variables
	public int getSickness() {
		return sicknessLevel;
	}

	public int getAge() {
		return age;
	}

	public int returnAmount() {
		return amount;
	}

	public void increaseThings() { 
		//increases things every hour
		this.hunger += 2;
		this.age++;
	}
	//necessary function
	public Tile getTileType(FarmTile aa){
		if( aa == null) return Tile.DIRT;
		return aa.getTType();
	}
}