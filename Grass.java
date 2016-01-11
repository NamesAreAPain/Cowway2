public class Grass extends FarmTile {
	
	private String name;
	private int sickness;

	public Grass() {
		this.name = Phrase.ADJECTIVE.get() + "the Grass";
	}
	
	public void increaseThings() {//increases things every hour
		this.quantity++;
		this.sickness = 0;
	}

	public void doStuffEveryHour(int hour) {
		increaseThings();
	}

	public int returnAmount() {
		return amount;
	}

	public int returnSickness() {
		returnSickness;
	}
}