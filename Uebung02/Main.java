
public class Main {
    public static void main(String[] args) {
        int guthaben = 1000;
        String eingabe = "";
        while (!eingabe.equals("STOP")) {
            eingabe = SimpleIO.getString("Bitte geben Sie eine Operation (GUTHABEN, EINZAHLEN, ABHEBEN, ZINSESZINS, STOP) ein :");
            switch (eingabe) {
                case "GUTHABEN" -> SimpleIO.output("Guthaben: " + guthaben + " EURO");
                case "EINZAHLEN" -> {
                    SimpleIO.output("Wie viel Geld möchten Sie einzahlen ? Es wird eine Gebühr von 5% berechnet .\n");
                    int einzahlung = SimpleIO.getInt("Summe: ");
                    while (einzahlung < 0) {
                        SimpleIO.output("Bitte geben Sie einen positiven Betrag ein.");
                        einzahlung = SimpleIO.getInt("Summe: ");
                    }
                    guthaben += (int) Math.ceil(einzahlung * 0.95);
                    SimpleIO.output("Guthaben: " + guthaben + " EURO");
                }
                case "ABHEBEN" -> {
                    int auszahlung = SimpleIO.getInt("Wie viel Geld möchten Sie abheben: ");
                    while (auszahlung < 0) {
                        auszahlung = SimpleIO.getInt("Geben Sie einen positiven Betrag ein: ");
                    }
                    while (auszahlung > guthaben) {
                        auszahlung = SimpleIO.getInt("Zu wenig Guthaben auf dem Konto: ");
                    }
                    guthaben -= auszahlung;
                    SimpleIO.output("Guthaben: " + guthaben + " EURO");
                }
                case "ZINSESZINS" -> {
                    int jahre = SimpleIO.getInt("Wie viele Jahre wollen Sie Ihr Guthaben verzinsen?");
                    for (int i = 0; i < jahre; i++) {
                        guthaben = (int) Math.ceil(guthaben * 1.04) -2;
                        if (guthaben < 0) {
                            guthaben = 0;
                            break;
                        }
                    }
                    SimpleIO.output("Guthaben: " + guthaben + " EURO");
                } case "STOP" ->
                        SimpleIO.output("Ihr Guthaben beträgt " + guthaben + " EURO. Vielen Dank und bis zum nächsten Mal!");
            }
        }
    }
}