public class NocturnalCow extends Cow {

	public NocturnalCow(Farm farm, Tile ttype) {
		super(farm, type);
		this.name = Phrase.ADJECTIVE.get() + Phrase.NAME.get() + "the Nocturnal Cow";
		this.ttype = Tile.NOCTURNALCOW;
	}

	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}

	public void doStuffForAnHour(int hour) {
		increaseThings();
		if (hour < 6 || hour > 18) {
			int direct = random(rand, 1, 4);
			Dir direct1 = null;
			if (direct == 1) {
				//north
				direct1 = Dir.NORTH;
			} else if (direct == 2) {
				//east
				direct1 = Dir.EAST;
			} else if (direct == 3) {
				//south
				direct1 = Dir.SOUTH;
			} else if (direct == 4) {
				//west
				direct1 = Dir.WEST;
			}

			if (farm.getThing(direct1.go(getLoc())).getType().equals("Grass")) {
				this.hunger -= farm.getThing(direct1.go(getLoc())).returnAmount();
				this.sicknessLevel += farm.getThing(direct1.go(getLoc())).returnSickness();
				farm.moveThing(this, direct1);
			} else {
				farm.moveThing(this, direct1);
			}

			int randInt = random(rand, 1, 100);
			int sick = (0.000001*age*sicknessLevel);
			if (hunger == 100 || age == 90001 || sick > randInt) {
				rapture();
			}
		}
	}	
}