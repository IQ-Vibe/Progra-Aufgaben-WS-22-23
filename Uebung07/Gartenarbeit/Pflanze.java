public sealed abstract class Pflanze permits Rosengewaechs, BlauerEisenhut, Salbei {

	/*
	 * Attributes
	 */
	public int maxLaenge;
	public int laenge;
	public int wachstum;

	/*
	 * Constructors
	 */
	public Pflanze(int maxLaenge, int laenge, int wachstum) {
		if (laenge <= maxLaenge) {
			this.laenge = laenge;
		} else {
			this.laenge = 0;
		}

		this.maxLaenge = maxLaenge;
		this.wachstum = wachstum;
	}

	/*
	 * Getter
	 */
	public int getMaxLaenge() {
		return maxLaenge;
	}

	public int getLaenge() {
		return laenge;
	}

	public int getWachstum() {
		return wachstum;
	}

	/*
	 * Methods
	 */
	public void waessern() {
		if ((this.laenge += this.wachstum) < this.maxLaenge) {
			this.laenge += this.wachstum;
		} else
			this.laenge = this.maxLaenge;
	}

	public abstract void schneiden(int x);
}
