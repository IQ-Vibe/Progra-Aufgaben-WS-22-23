import mySets.MyMutableSet;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyMutableSet<Integer> intSet = new MyMutableSet<>();
        intSet.addAll(Arrays.asList(1, 2, 3, 30, 40));
        System.out.println(intSet.toString() + " " + intSet.size());
        System.out.println(intSet.powerset().toString() + " " + intSet.powerset().size());
        System.out.println(intSet.toString() + " " + intSet.size());
        intSet.removeAll(Arrays.asList(30, 40));
        System.out.println(intSet.toString() + " " + intSet.size());
    }
}
