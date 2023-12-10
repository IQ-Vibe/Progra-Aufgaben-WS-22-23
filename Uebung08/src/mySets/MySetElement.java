package mySets;
class MySetElement<T>{
    T wert;
    MySetElement <T> next;
    public MySetElement(T wert, MySetElement<T> next){
        this.wert = wert;
        if(next != null){
            this.next = next;
        }
    }
}
