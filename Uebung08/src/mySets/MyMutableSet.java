package mySets;
import java.util.Collection;
import java.util.Set;
public non-sealed class MyMutableSet<T> extends MyAbstractSet<T> implements Set<T>{

    public static void main(String[] args) {
        MyMutableSet<Integer> intSet = new MyMutableSet<>();
        intSet.add(17);
        intSet.add(23);
        System.out.println("Set: " + intSet);
        System.out.println("Potenzmenge: " + intSet.powerset().toString());
        System.out.println("Paare: " + intSet.pairs().toString());
        System.out.println("Nummerierte Menge: " + intSet.enumerate().toString());
        System.out.println("numberOfSubsets: " + intSet.numberOfSubsets().toString());
    }

    public MyMutableSet(){
        super(null);
    }

    public MyMutableSet(Object o){
        super(new MySetElement<T>((T)o,null));
    }

    public boolean add(Object o) {
        if(!contains(o)){
            this.head = new MySetElement<>((T) o, this.head);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean added = false;
        for(Object o : c){
            if(!contains(o)){
                add(o);
                added = true;
            }
        }
        return added;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public boolean remove(Object o) {
        if(contains(o)){
            MySetIterator<T> i = iterator();
            if(i.current.wert.equals(o)){
                if(i.hasNext()){
                    i.next();
                    this.head = i.current;
                    return true;
                }
                else {
                    this.head = null;
                    return true;
                }
            }
            while(i.hasNext()){
                MySetElement<T> old = i.current;
                i.next();
                if(i.current.wert.equals(o)){
                    old.next = i.current.next;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean removed = false;
        for(Object o : c){
            if(remove(o)){
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    public MyMutableSet<MyMutableSet<T>> powerset(){
        MyMutableSet<MyMutableSet<T>> res = new MyMutableSet<>(new MyMutableSet<>()); //zukünftige Potenzmenge mit leerer Menge als Element

        int max = (int) Math.pow(2,size()) - 1; // größte zahl mit size()-bits

        for(int i = 1;i <= max;i++){
            MyMutableSet<T> subset = new MyMutableSet<T>(); //hinzuzufügende Menge
            String binary = Integer.toBinaryString(i);      //jetzige Zahl in binär
            while(binary.length() < Integer.toBinaryString(max).length()){binary = "0" + binary;}
            for(int k = 0 ;k < binary.length();k++){
                if(binary.charAt(k) == '1'){    //Element an k-ter Stelle in der Menge gehört zu hinzuzufügenden Menge
                    MySetIterator<T> iterator = iterator();
                    for(int j = 0; j < k;j++){iterator.next();} //an die entsprechende Stelle iterieren
                    subset.add(iterator.current.wert);  // Element der Menge hinzufügen
                }
            }

            res.add(subset);    // Teilmenge hinzufügen
        }
        return res; //Potenzmenge
    }

    public MyMutableSet<MyPair<T,T>> pairs(){
        MyMutableSet<MyPair<T,T>> res = new MyMutableSet<>();
        for(T l : this){
            for(T r : this){
                res.add(new MyPair<T,T>(l,r));
            }
        }
        return res;
    }

    public MyMutableSet<MyPair<Integer,T>> enumerate(){
        MyMutableSet<MyPair<Integer,T>> res = new MyMutableSet<>();
        int count = 0;
        for(T o : this){
            res.add(new MyPair<Integer,T>(count++,o));
        }
        return res;
    }

    public MyMutableSet<MyPair<MyMutableSet<T>,Integer>> numberOfSubsets(){
        MyMutableSet<MyPair<MyMutableSet<T>,Integer>> res = new MyMutableSet<>();
        MyMutableSet<MyMutableSet<T>> potenzmenge = powerset();

        for(MyMutableSet<T> o: potenzmenge){
            res.add(new MyPair<MyMutableSet<T>,Integer>(o,o.powerset().size()));
        }
        return res;
    }

    public MyMinimalSet<T> freezeAndClear(){
        MyImmutableSet<T> res = new MyImmutableSet<>(this.head);
        clear();
        return res;
    }
}
