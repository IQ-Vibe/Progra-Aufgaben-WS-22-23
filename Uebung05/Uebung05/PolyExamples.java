import java.util.Arrays;

/**
 * Die Beispiele aus der Übungsaufgabe
 */
public class PolyExamples {

    /**
     *  Führt die Beispiele aus der Übungsaufgabe aus und gibt die Ergebnisse aus
     *  @param args Eine Array von Argumenten, welches ignoriert wird
     */
    public static void main (String args[]) {
        Polynomial p = new Polynomial(new int[]{4,0,1});
        System.out.println("Polynomial.toString() "+p);
        System.out.println("");

        Polynomial addp1 = new Polynomial(new int[]{4,0,1});
        Polynomial addp2 = new Polynomial(new int[]{-4,3,2,1});
        System.out.println("Polynomial.add: ("+addp1+") + ("+addp2+") = "+ Arrays.toString(addp1.add(addp2)));
        System.out.println("");

        Polynomial ptmp = new Polynomial(new int[]{4,0,1,0,0});
        System.out.println("Polynomial.trim test: "+p);
        System.out.println("");

        Complex z1 = new Complex(1,2);
        Complex z2 = new Complex(3,4);
        System.out.println("Complex.add: "+z1+" + "+z2+" = "+z1.add(z2));
        System.out.println("Complex.mul: "+z1+" * "+z2+" = "+z1.mul(z2));

        System.out.println("Polynomial.eval: ("+p+")(2) = "+p.eval(2));
        System.out.println("Polynomial.eval: ("+p+")(0 + 2i) = Da"+p.eval(new Complex(0,2)));
        System.out.println("");

        Complex[] allIntegralRoots = p.allIntegralRoots();
        System.out.print("allIntegralRoots: ");
        for (Complex z : allIntegralRoots) {
            System.out.print(z+", ");
        }
        System.out.println("");
    }
}
