package mySets;
import java.lang.Iterable;
import java.util.*;

abstract sealed class MyAbstractSet<T> implements Iterable<T>, Set<T>, Collection<T> permits MyImmutableSet, MyMutableSet {
    MySetElement<T> head;

    public MyAbstractSet(MySetElement<T> o) {
        head = o;
    }

    @Override
    public MySetIterator<T> iterator(){
        return new MySetIterator<T>(head);
    }
    public <T> T[] toArray(T[] a){
        throw new UnsupportedOperationException();
    }

    public Object[] toArray(){
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object o){
        MySetIterator<T> iterator = iterator();
        while(iterator.hasNext()){
            if(iterator.current.wert.equals(o)){
                return true;
            }
            iterator.next();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object o : c){
            if(!contains(o)){return false;}
        }
        return true;
    }

    public boolean isEmpty(){
        return head == null;
    }


    public int size() {
        MySetIterator <T> i = iterator();
        int size = 0;
        while(i.hasNext()){
            size++;
            i.next();
        }
        return size;
    }

    @Override
    public String toString() {
        MySetIterator <T> i = iterator();
        String output = "{";
        while(i.hasNext()){
            output += i.current.wert.toString();
            if(i.current.next != null){output += ",";}
            i.next();
        }
        return output + "}";
    }

    @Override
    public boolean equals ( Object other ) {
        if ( other instanceof MyAbstractSet <?>) {
            return this.containsAll((Collection <?>) other) && this.size() == ((MyAbstractSet <?>) other).size();
        }
        return false ;
    }
}
