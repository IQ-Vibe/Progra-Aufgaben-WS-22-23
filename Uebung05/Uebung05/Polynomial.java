/**
 * Datentyp Polynomial zur Speicherung eines Polynoms.
 * @author Adil Acikgoez
 */
public class Polynomial{

    private int[] kofaktoren;

    /**
     * Die Kofaktoren des Objekts werden mit einem leeren Array initialisert.
     */
    public Polynomial(){
        kofaktoren = new int[]{};
    }

    /**
     * Die Kofaktoren des Objekts werden mit einer Kopie des mitgegeben Arrays initialisiert.
     * @param a Array vom Typ Integer der die Kofaktoren des Polynoms
     *          aufsteigend angeordnet nach Exponenten beginnend bei x^0 beinhaelt.
     */
    public Polynomial(int[] a){
        kofaktoren = a.clone();
        trim();
    }

    /**
     * @return gibt eine Kopie des Arrays Kofaktoren zurück.
     */
    public int[] get_array(){
        return kofaktoren.clone();
    }

    /**
     * @return gibt das Polynom als String zurück.
     */
    public String toString(){
        String res = "";
        if(kofaktoren.length > 0){
            res += kofaktoren[0] + "xˆ" + 0;
            for(int i = 1; i < kofaktoren.length;i++){

                res += " + " + kofaktoren[i] + "xˆ" + i ;
            }
            return res;
        }
        else return "0";

    }

    /**
     * Addiert das mitgegebene Polynom mit dem lokalen Polynom.
     * @param polynomial Objekt der Klasse Polynomial
     * @return Ergebnis der Addition als Array vom Typ Integer.
     */
    public int[] add(Polynomial polynomial){
        int[] res;
        int[] a = polynomial.get_array();

        if(kofaktoren.length > a.length){
            res = new int[kofaktoren.length];
            for(int i = 0;i<a.length;i++){
                res[i] = kofaktoren[i] + a[i];
            }
            res = kofaktoren.clone();
        }
        else{
            res = new int[a.length];
            for(int i = 0;i<kofaktoren.length;i++){
                res[i] = kofaktoren[i] + a[i];
            }
            res = a.clone();

        }
        return res;
    }

    private void trim(){
        int i = kofaktoren.length-1;
        while(kofaktoren[i] == 0 && i >= 0){
            i-= 1;
        }

        int[] res = new int[i+1];
        for(int k = 0; k < i+1;k++){
            res[k] = kofaktoren[k];
        }
        kofaktoren = res.clone();
    }

    /**
     * Setzt einen Wert für x in das Polynom ein.
     * @param x einzusetzender Wert
     * @return Ergebnis als double Wert
     */
    public double eval(double x){
        double sum = 0;
        for(int i = 0; i < kofaktoren.length;i++){
            sum += kofaktoren[i] * Math.pow(x,i);
        }
        return sum;
    }

    /**
     * Setzt eine Komplexe Zahl ein in das Polynom
     * @param z die einzusetzende Zahl vom Typ Complex
     * @return Ergebnis als Komplexe Zahl vom Typ Complex
     */
    public Complex eval(Complex z){
        double res = 0;
        Complex sum = new Complex(0,0);

        for(int i = 0; i < kofaktoren.length;i++){
            Complex z2 = potenziere(i,z);
            sum = sum.add(new Complex(kofaktoren[i],0).mul(z2));
        }
        return sum;
    }

    private Complex potenziere(int a,Complex z){
        if(a == 0){
            return new Complex(1,0);
        }
        Complex res = new Complex(z.a(),z.b());
        for(int i = 0; i < a-1; i++) {
            res = res.mul(z);
        }
        return res;
    }

    /**
     * Berechnet eine Obere Schranke für den möglichen Betrag aller Nullstellen des Polynoms
     * @return Obere Schranke
     */
    public double rootBound(){
        double sum = 0;
        for(int i = 0; i < kofaktoren.length-1;i++){
            sum += Math.abs(kofaktoren[i]/kofaktoren[kofaktoren.length-1]);
        }
        if(sum>1){
            return sum;
        }
        else return 1;


    }

    /**
     * Liefert alle komplexen Lösungen des Polynoms mit einer Oberen Schranke für den Fall p(z) = 0 mit z als Komplexer Zahl.
     * @return Array vom Typ Komplex mit allen Komplexen Lösungen
     */
    public Complex[] allIntegralRoots(){
        Complex[] c = new Complex[]{};
        double grenzwert = rootBound();

        for(int i = (int)grenzwert * -1;i < grenzwert+1;i++){
            for (int j = (int)grenzwert * -1; j < grenzwert; j++) {

                Complex nullstelle = eval(new Complex(i,j));
                if(nullstelle.a() == 0 && nullstelle.b() == 0){

                    if(Math.pow(i,2) + Math.pow(j,2) <= Math.pow(grenzwert,2)){

                        Complex[] temp2 = new Complex[c.length+1];

                        for(int k = 0; k < c.length; k++) {
                            temp2[k] = c[k];
                        }
                        //hinzufügen des neuen Elements
                        temp2[c.length] = new Complex(i,j);
                        c = temp2.clone();
                    }
                }
            }
        }
        return c;
    }
}
