public final class BlauerEisenhut extends Pflanze {
	
	/*
	 * Constructors
	 */
	public BlauerEisenhut() {
		super(5,1,1);
	}
    /*
     * Methods
     */
	public void schneiden(int x) {
		if (x < 0) {System.out.println("Fuck you, positive int");
		} else {if (this.laenge < 1) {
		} else this.laenge = 1;
	}
	}
}
