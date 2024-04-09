
/**
 * Class Node for StrBST
 */
public class DictionaryNode {
  /** A public member variable to hold the value of node as a string. */
  protected String value;
  /** A public member variable to hold a link to the left subtree. */
  protected DictionaryNode left;
  /** A public member variable to hold a link to the left subtree. */
  protected DictionaryNode right;
  /**
   * Add a public member variable to your DictionaryNode class that holds the
   * definition of a word/phrase as a string
   */
  protected String definition;

  /**
   * A constructor that takes a value as a string argument and copies that value
   * into the node’s member variable. The constructor should also initialize the
   * left and right subtree links to null.
   * 
   * @param val the value to a DictionaryNode
   */
  DictionaryNode(String val, String def) {
    this.value = val;
    // set left and right to null
    this.left = null;
    this.right = null;
    this.definition = def;
  }
}
