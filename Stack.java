/**
 * Represents a stack data structure.
 */
public class Stack {

  /**
   * Represents a node in the stack.
   */
  protected class Node {
    String value;
    Node next;

    /**
     * Initializes a node with a given value.
     * 
     * @param x The value of the node.
     */
    Node(String x) {
      value = x;
    }
  }

  /**
   * The top node of the stack.
   */
  public Node root;

  /**
   * Adds an item to the start of the stack.
   * 
   * @param x The item to be added.
   */
  public void push(String x) {
    Node n = new Node(x);
    n.next = this.root;
    this.root = n;
  }

  /**
   * Removes and returns the item from the start of the stack.
   * 
   * @return The value of the removed item, or null if the stack is empty.
   */
  public String pop() {
    if (isEmpty()) {
      return null;
    }

    Node first = root;
    root = first.next;
    return first.value;
  }

  /**
   * Returns the value of the first item in the stack without removing it.
   * 
   * @return The value of the first item, or null if the stack is empty.
   */
  public String peek() {
    if (isEmpty()) {
      return null;
    }

    return root.value;
  }

  /**
   * Checks if the stack is empty.
   * 
   * @return True if the stack is empty, false otherwise.
   */
  public boolean isEmpty() {
    return root == null;
  }

  /**
   * Returns the number of items in the stack.
   * 
   * @return The number of items in the stack.
   */
  public int length() {
    int count = 0;
    Node curr = root;

    while (curr != null) {
      count++;
      curr = curr.next;
    }

    return count;
  }

  /**
   * Prints the contents of the stack to standard output.
   */
  public void dump() {
    String str = "";
    Node curr = root;

    while (curr != null) {
      str += curr.value + "->";
      curr = curr.next;
    }

    System.out.print(str);
  }

}
