package mySets;

import java.util.Iterator;
import java.util.NoSuchElementException;

class MySetIterator<T> implements Iterator<T> {         //Iterator<T> necessary?
    public MySetElement<T> current;

    public MySetIterator(MySetElement<T> current){
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() throws NoSuchElementException{
        MySetElement<T> currenthelp = current;
        if(current == null) throw new NoSuchElementException();
        current = current.next;
        return currenthelp.wert;
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
