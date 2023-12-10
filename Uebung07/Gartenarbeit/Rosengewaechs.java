public sealed abstract class Rosengewaechs extends Pflanze permits Lorbeerkirsche, Himbeere {

	/*
	 * Attributes
	 */
	public int verbreitung;

	/*
	 * Constructors
	 */
	public Rosengewaechs(int laenge, int maxLaenge, int wachstum, int verbreitung) {
		super(maxLaenge, laenge, wachstum);
		this.verbreitung = verbreitung;
	}

	/*
	 * Getter
	 */
	public int getVerbreitung() {
		return verbreitung;
	}

	/*
	 * Methods
	 */
	@Override
	public void waessern() {
		this.laenge += this.verbreitung * this.wachstum;
	}

}
