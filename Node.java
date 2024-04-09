
/**
 * Class Node for StrBST
 */
public class Node {
  /** A public member variable to hold the value of node as a string. */
  protected String value;
  /** A public member variable to hold a link to the left subtree. */
  protected Node left;
  /** A public member variable to hold a link to the left subtree. */
  protected Node right;

  /**
   * A constructor that takes a value as a string argument and copies that value
   * into the node’s member variable. The constructor should also initialize the
   * left and right subtree links to null.
   * 
   * @param val the value to a Node
   */
  Node(String val) {
    this.value = val;
    // set left and right to null
    this.left = null;
    this.right = null;
  }
}
