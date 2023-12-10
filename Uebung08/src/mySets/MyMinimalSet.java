package mySets;

import java.util.Collection ;
import java.lang.Iterable;
public interface MyMinimalSet<T> extends Iterable<T> {

    void addAllTo(Collection<T> col) throws UnmodifiableCollectionException;
    boolean contains(T t);
}
