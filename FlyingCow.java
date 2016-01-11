public class FlyingCow extends Cow {

	public FlyingCow() {
		this.name = Phrase.ADJECTIVE.get() + Phrase.NAME.get() + "the Flying Cow";
	}

	public void doStuffForAnHour(int hour) {
		increaseThings();
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