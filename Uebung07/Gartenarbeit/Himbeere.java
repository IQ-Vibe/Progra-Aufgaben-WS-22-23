public final class Himbeere extends Rosengewaechs implements IstEssbar {

	/*
	 * Constructors
	 */
	public Himbeere() {
		super(1, 10, 1, 2);
	}
	/*
	 * Methods
	 */

	@Override
	public void schneiden(int x) {
		System.out.println("himbeer");
		if (x < 0) {
			System.out.println("Fuck you, positive int");
		} else {
			if ((this.laenge -= x) < 0) {
			} else
				this.laenge -= x;
		}
	}

	@Override
	public boolean essen() {
		if ((this.laenge -= 2) >= 0) {
			this.laenge -= 2;
			return true;
		} else
			return false;
	}
}