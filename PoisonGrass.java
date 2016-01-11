public class PoisonGrass extends Grass {

	public PoisonGrass() {
		this.name = Phrase.ADJECTIVE.get() + "the Poison Grass";
	}

	public void increaseThings() {
		this.amount += 2;
		this.sickness = this.quantity;
	}
}