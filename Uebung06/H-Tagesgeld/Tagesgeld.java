public class Tagesgeld {
    private int maxBetrag;
    private int angebotsmonate;
    private double angebotszinsen;
    private double normalzinsen;

    public static void main(String[] args) {

        Tagesgeld t = new Tagesgeld(50000, 6, 4.0, 1.5);
        System.out.println(Tagesgeld.bestesTagesgeld(150000, 12, t, t1, t2).angebotszinsen);
    }

    public Tagesgeld(int maxBetrag, int angebotsmonate, double angebotszinsen, double normalzinsen) {
        this.maxBetrag = maxBetrag;
        this.angebotsmonate = angebotsmonate;
        this.angebotszinsen = angebotszinsen;
        this.normalzinsen = normalzinsen;
    }

    public int getMaxBetrag() {
        return maxBetrag;
    }

    public int getAngebotsmonate() {
        return angebotsmonate;
    }

    public double getAngebotszinsen() {
        return angebotszinsen;
    }

    public double getNormalzinsen() {
        return normalzinsen;
    }

    public static double jahresZuMonatszins(double jahreszins) {
        return (Math.pow((jahreszins * 0.01) + 1, (double) 1 / 12) - 1) * 100;
    }

    public double verzinse(double init, int monate) {
        if (monate == 0) {
            return init;
        }
        if (init < getMaxBetrag()) {
            if (angebotsmonate > 0) {
                angebotsmonate--;
                return verzinse(init * ((jahresZuMonatszins(getAngebotszinsen()) * 0.01) + 1), monate - 1);
            } else {
                return verzinse(init * ((jahresZuMonatszins(getNormalzinsen()) * 0.01) + 1), monate - 1);
            }
        } else if (getMaxBetrag() < 100000) {
            if (angebotsmonate > 0) {
                angebotsmonate--;
                return verzinse((getMaxBetrag() * ((jahresZuMonatszins(getAngebotszinsen()) * 0.01) + 1))
                        + (init - getMaxBetrag()), monate - 1);
            } else {
                return verzinse((getMaxBetrag() * ((jahresZuMonatszins(getNormalzinsen()) * 0.01) + 1))
                        + (init - getMaxBetrag()), monate - 1);
            }
        } else {
            if (angebotsmonate > 0) {
                angebotsmonate--;
                return verzinse((100000 * ((jahresZuMonatszins(getAngebotszinsen()) * 0.01) + 1)) + (init - 100000),
                        monate - 1);
            } else {
                return verzinse((100000 * ((jahresZuMonatszins(getNormalzinsen()) * 0.01) + 1)) + (init - 100000),
                        monate - 1);
            }
        }
    }

    public static Tagesgeld bestesTagesgeld(double init, int monate, Tagesgeld... ts) {
        return rekursion(init, monate, ts, ts.length - 1, ts[ts.length - 1]);
    }

    private static Tagesgeld rekursion(double init, int monate, Tagesgeld[] ts, int index, Tagesgeld bestes) {
        if (index == 0) {
            return bestes;
        } else if (bestes.verzinse(init, monate) < ts[index - 1].verzinse(init, monate)) {
            bestes = ts[index - 1];
        }
        return rekursion(init, monate, ts, index - 1, bestes);
    }
}