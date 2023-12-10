public final class Salbei extends Pflanze implements IstEssbar {

	/*
	 * Constructors
	 */
	public Salbei() {
		super(6, 1, 1);
	}
	/*
	 * Methods
	 */

	@Override
	public void schneiden(int x) {
		if (x < 0) {
			System.out.println("Fuck you, positive int");
		} else {
			if ((this.laenge -= x) < 0) {}
			else this.laenge -= x;
		}
	}

	@Override
	public boolean essen() {
		if ((this.laenge -= 1) >= 0) {
			this.laenge -= 1;
			return true;
		} else return false;
	}
}
