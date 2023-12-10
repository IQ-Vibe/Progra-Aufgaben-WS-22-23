public class TreeListElement {
  private Tree value;
  private int kids = 0;
  private TreeListElement next;

  /**
   *
   * @param inputValue The value of the new TreeListElement
   * @param inputNext  The next elements of the TreeListElement
   */
  public TreeListElement(Tree inputValue, TreeListElement inputNext) {
    this.value = inputValue;
    this.next = inputNext;
  }

  // a)
  public Tree getValue() {
    return value;
  }

  public void setValue(Tree newValue) {
    value = newValue;
  }

  public TreeListElement getNext(){
    return next;
  }

  public void setNext(TreeListElement newNext){
    next = newNext;
  }

  // b)

  /**
   * Hilfsmethode um die Datenstruktur als String auszugeben.
   * @return
   */
  public String toString(){
    if (value.getChildren() == null) {
      return Integer.toString(value.getLabel()) + "->[]";
    } else {
      return value.toString();
    }

  }
  // c)

  /**
   * Hilfsmethode um die Tiefe der Datenstruktur zu bestimmen.
   * @return
   */
  public int branchingDegree(){
    kids += 1;
    if (getNext() != null) {
      return getNext().branchingDegree();
    }
    return Math.max(kids, value.branchingDegree());
  }

  // d)

  /**
   * Hilfsmethode um zu ermittlen ob der mitegegebene Wert in der Datenstrukur enthalten ist.
   * @param toSearch
   * @return
   */
  public boolean contains(int toSearch){
    if(value.getChildren() == null){
      return value.getLabel() == toSearch;
    }
    else return value.contains(toSearch);
  }
  // e)

  /**
   * Hilfsmethode um die Datenstruktur zu erzeugen
   * @param zweige
   * @param index
   * @return
   */
  public static TreeListElement buildTree(Tree[] zweige, int index){
    if(index <= zweige.length -2){
      return new TreeListElement(zweige[index],buildTree(zweige,index+1));
    }
    return new TreeListElement(zweige[index],null);
  }
}