package mySets;

import java.util.Collection;

non-sealed class MyImmutableSet<T> extends MyAbstractSet<T> implements MyMinimalSet<T>{

    public MyImmutableSet(MySetElement<T> head) {
        super(head);
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addAllTo(Collection<T> col) throws UnmodifiableCollectionException {
        try {
          col.addAll(this);
        } catch (UnsupportedOperationException e){
            throw new UnmodifiableCollectionException();
        }
    }

}
