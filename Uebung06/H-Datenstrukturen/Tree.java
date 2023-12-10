import java.util.Arrays;

public class Tree {
  private int label;

  private TreeList children;

  /**
   * Konstruktor der Klasse Tree
   * @param inputLabel
   * @param inputChildren
   */
  public Tree(int inputLabel, TreeList inputChildren) {
    this.label = inputLabel;
    this.children = inputChildren;
  }

  // a)

  /**
   * Gibt den Wert der Klassenvariable label zurück.
   * @return
   */
  public int getLabel() {
    return label;
  }

  /**
   * Ersetzt den Wert der Klassenvariable label mit dem mitgegebenen Parameter
   * @param label
   */
  public void setLabel(int label) {
    this.label = label;
  }

  /**
   * Gibt den Wert der Klassenvariable children wieder
   * @return
   */
  public TreeList getChildren() {
    return children;
  }

  /**
   * Ersetzt den Wert der Klassenvariable children mit dem mitgegebenen Parameter
   * @param newChildren
   */
  public void setChildren(TreeList newChildren) {
    children = newChildren;
  }
  // b)

  /**
   * Gibt Die Datenstruktur der einem Tree zugehört als String aus
   * @return
   */
  public String toString() {
    if (children == null) {
      return "";
    } else
      return label + "->[" + children.toString() + "]";
  }

  // c)

  /**
   * Gibt die Tiefe der Datenstruktur wieder.
   * @return
   */
  public int branchingDegree(){
    if(getChildren() == null){
      return 0;
    }
    return children.branchingDegree();
  }

  // d)

  /**
   * Gibt wieder ob ein Parameter vom Typ int der Datenstruktur enthalten ist.
   * @param toSearch
   * @return
   */
  public boolean contains(int toSearch){
    if(label == toSearch){
      return true;
    }
      if (children == null) return false;
      else return children.contains(toSearch);

}

  // e)

  /**
   * Erzeugt die Datenstruktur Tree mithilfe der mitgegebenen Parameter und gibt den Kopf der Datenstrukur aus.
   * @param value
   * @param children
   * @return
   */
  public static Tree buildTree(int value, Tree... children){
    return new Tree(value,TreeList.buildTree(children));
  }

  /**
   * Method for trying out some of the implemented commands.
   *
   * @param args input strings from the console
   */

  public static void main(String[] args) {
    Tree[] trees = { buildTree(1, buildTree(2), buildTree(3), buildTree(4)), buildTree(-1),
            buildTree(4,
                    buildTree(1,
                            buildTree(1, buildTree(1, buildTree(1), buildTree(1), buildTree(1)), buildTree(1), buildTree(1))),
                    buildTree(2), buildTree(2, buildTree(2))),
            buildTree(72, buildTree(27), buildTree(11),
                    buildTree(54, buildTree(89, buildTree(10), buildTree(20), buildTree(42))), buildTree(23)),
            buildTree(54, buildTree(89, buildTree(10), buildTree(20), buildTree(42))) };

    for (Tree tree : trees) {
     if (tree != null) {
      String test = "";
      test = test + tree.toString() + "\n";
      test = test + "Branching Degree: " + tree.branchingDegree() + "\n";
      test = test + "2 contained: " + tree.contains(2) + "\n";
      test = test + "42 contained: " + tree.contains(42) + "\n";
      test = test + "1 contained: " + tree.contains(1) + "\n";
      SimpleIO.output(test);
    }
    }

  }

}