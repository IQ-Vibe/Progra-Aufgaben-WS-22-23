import java.util.Random;

public class Statistics {

	// ...
	int size = 100;
	int[] werte = new int[size];
	int anzahl = 0;

	public static void main(String[] args) {
		Statistics statistics = new Statistics();
		statistics.addValues(2,105,-366,44,11);
		SimpleIO.output("Minimum: " + statistics.getMinimum());
		SimpleIO.output("Maximum: " + statistics.getMaximum());
		SimpleIO.output("Durchschnitt: " + statistics.getAverage());
	}

	public void addValues(int... values) {
		// ...
		int i = 0;
		while (anzahl+values.length <= 100 && values.length != i){
			werte[anzahl] = values[i];
			anzahl++;
			i++;
		}
	}

	public int getMinimum() {
		// ...
		int min = 0;
		if(anzahl>0){
			min = werte[0];
			for(int i = 1;i< werte.length;i++){
				if(min>werte[i]) min=werte[i];
			}
		}

		return min;

	}

	public int getMaximum() {
		// ...
		int max = 0;
		if(anzahl>0){
			max = werte[0];
			for(int i = 1;i< anzahl;i++){
				if(max<werte[i]) max=werte[i];
			}
		}


		return max;
	}

	public double getAverage() {
		// ...
		int sum = 0;
		if(anzahl>0){
			for(int i = 0; i < anzahl;i++){
				sum += werte[i];
			}

		}
		return (double)sum/anzahl;
	}

	public Statistics generate(int min, int max, int size) {
		// ...
		if(min > max || size < 0 || size > 100){
			System.out.println("Es gab einen Fehler bei der Eingabe!");
			return null;
		}
		Statistics temp = new Statistics();
		temp.addValues(min,max);
		Random rand = new Random();

		for(int i = 2; i < size;i++) {
			temp.addValues(rand.nextInt(min,max+1));
		}
		return temp;
	}

	public OurColor interpret(double ratio, int value) {
		// ...
		double d = getAverage();
		double min = d - ratio * Math.abs(d);
		double max = d + ratio * Math.abs(d);

		if(d >= min && d <= max)
		{
			return OurColor.GELB;
		}
		if(d < min) return OurColor.ROT;
		else return OurColor.GRUEN;

	}
}

