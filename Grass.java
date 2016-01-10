public class Grass extends FarmTile {
	
	private int quantity;
	private int sickness;
	
	public void increaseThings() {//increases things every hour
		this.quantity++;
		this.sickness = 0;
	}

	public void doStuffEveryHour(int hour) {
		increaseThings();
	}

	public int returnAmount() {
		return quantity;
	}

	public int returnSickness() {
		returnSickness;
	}
}