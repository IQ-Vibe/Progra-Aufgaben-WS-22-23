/**
 * Datentyp Complex zur Speicherung einer Komplexen Zahl.
 * @param a Realteil der Komplexen Zahl.
 * @param b Imaginärteil der Komplexen Zahl.
 * @author Adil Acikgoez
 */
public record Complex(double a, double b){
    /**
     * Addiert die mitgegebene Komplexe Zahl zur lokalen Komplexen Zahl.
     * @param z vom Typ Complex.
     * @return Ergebnis der Addition als Objekt vom Typ Complex.
     */
    public Complex add(Complex z){return new Complex(a+z.a,b+z.b);}

    /**
     * Multipliziert die mitgegebene Komplexe Zahl mit der lokalen Komplexen Zahl.
     * @param z vom Typ Complex
     * @return Ergebnis der Multiplikation als Objekt vom Typ Complex.
     */
    public Complex mul(Complex z){
        return new Complex(a*z.a - b*z.b,a*z.b + b*z.a);
    }


}
