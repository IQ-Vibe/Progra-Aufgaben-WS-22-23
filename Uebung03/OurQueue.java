/**
 * Programm, welches eine einfache Queue implementiert
 */
public class OurQueue {
  public static void main(String[] args) {

    int length = -1;
    while (length < 0) {
      length = SimpleIO.getInt("Bitte geben Sie die initiale (nicht negative) Groesse ein :");
    }
    String[] queue = new String[length];
    int currentSize = 0;
    int i;

    String eingabe = "";
    while (!eingabe.equals("STOP")) {
      eingabe = SimpleIO.getString("Bitte geben Sie eine Operation (ENQUEUE, DEQUEUE, CLEAR, SETSIZE, PRINT, STOP)");
      switch (eingabe) {
        case "ENQUEUE" -> {
          if (currentSize < queue.length) {
            String neu = SimpleIO.getString("Geben Sie ein zu speicherndes Element ein: ");
            for (i = 1; i < queue.length; i++) {
              queue[queue.length - i] = queue[queue.length - 1 - i];
            }
            currentSize += 1;
            queue[0] = neu;
          } else {
            SimpleIO.output("Queue ist voll.");
          }
        }
        case "DEQUEUE" -> {
          if (currentSize > 0) {
            currentSize -= 1;
            queue[queue.length - 1] = "";
          }
        }
        case "SETSIZE" -> {
          int size = -1;
          while (size < 0) {
            size = SimpleIO.getInt("Bitte geben Sie die (nicht negative) Groesse ein: ");
          }
          String[] queue2 = new String[size];
          if (size < currentSize) {
            for (i = 0; i < size; i++) {
              queue2[queue2.length-i-1] = queue[queue.length-1-i];
            }
          } else {
            for (i = 0; i < currentSize; i++) {
              queue2[i] = queue[i];

            }
          }
          queue = queue2;
          currentSize = Math.min(currentSize, size);
        }
        case "CLEAR" -> {
          for (i = 0; i < queue.length; i++) {
            queue[queue.length - i - 1] = "";
            currentSize = 0;
          }
        }
        case "PRINT", "STOP" -> {
          if (currentSize == 0) {
            SimpleIO.output("Queue ist leer.");
          } else {
            StringBuilder print = new StringBuilder();
            for (String j : queue) {
              if (j == null) {
              } else if (j.isEmpty()) {
              } else if (j.equals(queue[0])) {
                print.insert(0, j);                                                                   //nice
              } else {
                print.insert(0, j + ", ");
              }
            }
            SimpleIO.output("Queue: " + print);
          }
        }
      }
    }
  }
}