public class Grass extends FarmTile {
	
	private int quantity;
	
	public void increaseStuff() {//increases things every hour
		this.quantity++;
	}

	public void doStuffEveryHour(int hour) {
		increaseStuff();
	}

	public int returnAmount() {
		return quantity;
	}
}