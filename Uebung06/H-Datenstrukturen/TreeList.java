public class TreeList {
  private TreeListElement head;

  /**
   * Standard Konstruktor der Klasse TreeList.
   */
  public TreeList() {
    this.head = null;
  }

  /**
   * Konstrukter der Klasse TreeList, welcher die TreeListElement variable "head" dem Parameter gleichsetzt.
   * @param head
   */
  public TreeList(TreeListElement head){
    this.head = head;
  }

  // a)
  public TreeListElement getHead() {
    return head;
  }

  public void setHead(TreeListElement newHead) {
    head = newHead;
  }

  // b)

  /**
   * Hilfsmethode um die Datenstruktur als String auszugeben.
   * @return
   */
  public String toString() {
    if (head == null) {
      return "";
    } else {
      return toStringRecursion(head);
    }
  }

  private String toStringRecursion(TreeListElement currElement) {
    if (currElement.getNext() == null) {
      return currElement.toString();
    } else {
      return currElement.toString() + "," + toStringRecursion(currElement.getNext());
    }
  }


  // c)

  /**
   * Hilfsmethode um die Tiefe der Datenstruktur wiederzugeben.
   * @return
   */
  public int branchingDegree(){
    if(head == null){
      return 0;
    }
    return branchingDegreeRecursion(head);
  }

  private int branchingDegreeRecursion(TreeListElement currElement){
    if(currElement.getNext() == null){
      return currElement.branchingDegree();
    } else {
      return Math.max(currElement.branchingDegree(), branchingDegreeRecursion(currElement.getNext()));
    }
  }


  // d)

  /**
   * Hilfsmethode um zu prüfen ob ein Wert in der Datenstruktur enthalten ist.
   * @param toSearch
   * @return
   */
  public boolean contains(int toSearch){
    if(head == null){
      return false;
    }
    return containsRecursion(head, toSearch);
  }

  private boolean containsRecursion(TreeListElement currElement,int toSearch){
    if(currElement != null){
      if(currElement.contains(toSearch)){
        return true;
      }
      else return containsRecursion(currElement.getNext(),toSearch);
    }
    else return false;
  }

  // e)

  /**
   * Hilfsmethode um die Datenstruktur zu erzeugen
   * @param zweige
   * @return
   */
  public static TreeList buildTree(Tree[] zweige){
    if(zweige.length == 0){
      return new TreeList();
    }
    return new TreeList(TreeListElement.buildTree(zweige,0));
  }
}