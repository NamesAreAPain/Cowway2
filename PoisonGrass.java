public class PoisonGrass extends Grass {
	public void increaseThings() {
		this.quantity += 2;
		this.sickness = this.quantity;
	}
}