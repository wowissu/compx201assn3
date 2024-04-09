/**
 * This class is to implement an unbalanced BST using self-referential nodes.
 * The solution should support the following public methods using recursion
 * where applicable
 */
class StrBST {
  /** the root node */
  Node root;

  /**
   * Insert a new value as a Node into the tree.
   * 
   * add the value to the BST, maintain ordering alphabetically by using the
   * compareTo method
   * (<a href="https://www.w3schools.com/java/ref_string_compareto.asp">click
   * here</a> for
   * more details) and assume that duplicates are not allowed.
   * 
   * @param s A value for insertion
   */
  public void insert(String s) {
    root = insertR(root, s);
  }

  /**
   * Private helper method for recursively insert a node into the tree
   * 
   * @param curr a current node for recursion
   * @param s    the value to be inserted into the tree
   * 
   * @return a node to put back to the tree
   */
  private Node insertR(Node curr, String s) {
    if (curr == null) {
      // the end of branch
      curr = new Node(s);
    }

    if (s.compareTo(curr.value) < 0) {
      // go left branch
      curr.left = insertR(curr.left, s);
    } else if (s.compareTo(curr.value) > 0) {
      // go right branch
      curr.right = insertR(curr.right, s);
    }

    return curr;
  }

  /**
   * Remove a value which is existed in the tree.
   * 
   * @param s A value for deletion
   */
  public void remove(String s) {
    root = removeR(root, s);
  }

  /**
   * Private helper method for recursively remove a node from the tree
   * 
   * @param curr a current node for recursion
   * @param s    the specific value to be removed from the tree
   * @return
   */
  private Node removeR(Node curr, String s) {
    if (curr == null) {
      return null;
    }

    if (s.compareTo(curr.value) < 0) {
      curr.left = removeR(curr.left, s);
    } else if (s.compareTo(curr.value) > 0) {
      curr.right = removeR(curr.right, s);
    } else {
      if (curr.left == null) {
        return curr.right;
      } else if (curr.right == null) {
        return curr.left;
      } else {
        Node leftmost = getLeftmost(curr.right);
        curr.value = leftmost.value;
        curr.right = removeR(curr.right, leftmost.value);
      }
    }

    return curr;
  }

  /**
   * Private helper to get the smallest node, which is left most one.
   * 
   * @param curr starting node
   * @return left most node
   */
  private Node getLeftmost(Node curr) {
    while (curr.left != null) {
      curr = curr.left;
    }
    return curr;
  }

  /**
   * Search a particular value.
   * 
   * @param s search specific value
   */
  public boolean search(String s) {
    return searchR(root, s);
  }

  /**
   * Private helper method for recursively search specific value in the tree.
   * 
   * @param curr the starting node.
   * @param s    the value.
   */
  private boolean searchR(Node curr, String s) {
    if (curr == null) {
      return false;
    }

    if (s.compareTo(curr.value) < 0) {
      return searchR(curr.left, s);
    } else if (s.compareTo(curr.value) > 0) {
      return searchR(curr.right, s);
    } else {
      return true;
    }
  }

  /**
   * To print out the tree following an <b><i>in-order traversal</i></b> with
   * each value on a separate line.
   */
  public void print() {
    printR(root);
  }

  /**
   * Private helper method for recursively printing the tree.
   * 
   * @param curr the starting node.
   */
  private void printR(Node curr) {
    if (curr == null) {
      return;
    }

    if (curr.left != null) {
      printR(curr.left);
    }

    System.out.printf("Root: %s | Left: %s | Right: %s \n", curr.value, curr.left == null ? null : curr.left.value,
        curr.right == null ? null : curr.right.value);

    if (curr.right != null) {
      printR(curr.right);
    }
  }
}