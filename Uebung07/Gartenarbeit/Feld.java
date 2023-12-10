public class Feld {
    Pflanze s = new Salbei();
    Pflanze b = new BlauerEisenhut();
    Rosengewaechs h = new Himbeere();
    Rosengewaechs l = new Lorbeerkirsche();

    Object[] ps = { s, b, h, l };

    public static Pflanze auswahl(PflanzenPaar pair) {
        Pflanze pflanze;
        switch (pair) {
            case PflanzenPaar(Pflanze p1, Pflanze p2) when p1 instanceof IstEssbar -> {
                while (pair.p1().getLaenge() < pair.p1().getMaxLaenge()) {
                    pair.p1().waessern();
                }
                if (pair.p1() instanceof Himbeere) {
                    ((Himbeere) pair.p1()).essen();
                }
                pflanze = pair.p1();
            }

            case PflanzenPaar(Pflanze p1, Pflanze p2) when p2 instanceof IstEssbar -> {
                while (pair.p2().getLaenge() < pair.p2().getMaxLaenge()) {
                    pair.p2().waessern();
                }
                if (pair.p2() instanceof Himbeere) {
                    ((Himbeere) pair.p2()).essen();
                }
                pflanze = pair.p2();
            }

            case PflanzenPaar(Pflanze p1, Pflanze p2) when (p1 instanceof BlauerEisenhut
                    && p2 instanceof Lorbeerkirsche) -> {
                if (pair.p2().laenge > 5) {
                    pflanze = p1;
                } else {
                    pflanze = p2;
                }
            }

            case PflanzenPaar(Pflanze p1, Pflanze p2) when (p1 instanceof Lorbeerkirsche
                    && p2 instanceof BlauerEisenhut) -> {
                if (pair.p1().laenge > 5) {
                    pflanze = p2;
                } else {
                    pflanze = p1;
                }
            }

            default -> {
                switch (pair.p1()) {
                    case Pflanze p when p instanceof Salbei -> {
                        while (pair.p1().getLaenge() < pair.p1().getMaxLaenge()) {
                            pair.p1().waessern();
                        }
                        pflanze = pair.p1();
                    }
                    case Pflanze p when p instanceof Himbeere -> {
                        while (pair.p1().getLaenge() < pair.p1().getMaxLaenge()) {
                            pair.p1().waessern();
                        }
                        ((Himbeere) pair.p1()).essen();
                        pflanze = pair.p1();
                    }

                    default -> {
                        pflanze = pair.p1();
                    }
                }
            }
        }
        return pflanze;
    }

    public static void main(String[] args) {
        Himbeere himbeere = new Himbeere();
        Lorbeerkirsche lorbeerkirsche = new Lorbeerkirsche();
        Lorbeerkirsche lorbeerkirscheLang = new Lorbeerkirsche();

        lorbeerkirsche.waessern();
        lorbeerkirsche.schneiden(6);

        lorbeerkirscheLang.waessern();
        lorbeerkirscheLang.waessern();
        Salbei salbei = new Salbei();
        BlauerEisenhut blauerEisenhut = new BlauerEisenhut();
        blauerEisenhut.schneiden(1);

        PflanzenPaar pair1 = new PflanzenPaar(himbeere, salbei);
        PflanzenPaar pair2 = new PflanzenPaar(himbeere, lorbeerkirsche);
        PflanzenPaar pair3 = new PflanzenPaar(lorbeerkirsche, blauerEisenhut);
        PflanzenPaar pair4 = new PflanzenPaar(lorbeerkirscheLang, blauerEisenhut);
        PflanzenPaar pair5 = new PflanzenPaar(lorbeerkirsche, salbei);

        System.out.println("Auswahl:" + auswahl(pair1) + ", Länge:" + auswahl(pair1).getLaenge());
        System.out.println("Auswahl:" + auswahl(pair2) + ", Länge:" + auswahl(pair2).getLaenge());
        System.out.println("Auswahl:" + auswahl(pair3) + ", Länge:" + auswahl(pair3).getLaenge());
        System.out.println("Auswahl:" + auswahl(pair4) + ", Länge:" + auswahl(pair4).getLaenge());
        System.out.println("Auswahl:" + auswahl(pair5) + ", Länge:" + auswahl(pair5).getLaenge());

    }

}