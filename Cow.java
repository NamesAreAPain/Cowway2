public class Cow extends FarmTile {
	
	private String Name;
	private int hunger;
	private int age;
	private int sicknessLevel;
	
	public void doStuffForAnHour(int hour) throws FileNotFoundException {
		increaseThings();
		if (hour < 19 || hour > 5) {
			int direct = random(rand, 1, 4);
			if (direct == 1) {
				//north
			} else if (direct == 2) {
				//east
			} else if (direct == 3) {
				//south
			} else if (direct == 4) {
				//west
			}
		}
	}

	public void increaseThings() {
		this.hunger += 2;
		this.age++;
	}

	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
}