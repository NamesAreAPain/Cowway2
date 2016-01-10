public class Cow extends FarmTile {
	
	private String Name;
	private int hunger;
	private int age;
	private int sicknessLevel;
	
	public void doStuffForAnHour(int hour) throws FileNotFoundException {
		increaseThings();
		if (hour < 19 || hour > 5) {
			
		}
	}

	public void increaseThings() {
		this.hunger += 2;
		this.age++;
	}
}