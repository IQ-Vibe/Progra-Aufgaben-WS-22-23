public final class Lorbeerkirsche extends Rosengewaechs {

	/*
	 * Constructors
	 */
	public Lorbeerkirsche() {
		super(1, 2147483647, 2, 3);
	}

	/*
	 * Methods
	 */
	@Override
	public void schneiden(int x) {
		if (x < 0) {
			System.out.println("Fuck you, positive int");
		} else {
			if (this.laenge - (x / 2) > 0) {
				this.laenge = this.laenge - (x / 2);
			}
		}
	}
}