package mySets;

public record MyPair<T,U>(T left, U right){
    @Override
    public String toString() {
        return "(" + left + "," + right + ')';
    }
}
