/**
 * This class is to implement an unbalanced BST using self-referential nodes.
 * The solution should support the following public methods using recursion
 * where applicable
 */
class DictionaryBST {
  /** the root node */
  DictionaryNode root;

  /**
   * Insert a new value as a Node into the tree.
   * 
   * add the value to the BST, maintain ordering alphabetically by using the
   * compareTo method
   * (<a href="https://www.w3schools.com/java/ref_string_compareto.asp">click
   * here</a> for
   * more details) and assume that duplicates are not allowed.
   * 
   * @param s          A value for insertion
   * @param definition A definition for {@code s}
   */
  public void insert(String s, String definition) {
    root = insertR(root, s, definition);
  }

  /**
   * Private helper method for recursively insert a node into the tree
   * 
   * @param curr       a current node for recursion
   * @param s          the value to be inserted into the tree
   * @param definition A definition for {@code value}
   * 
   * @return a node to put back to the tree
   */
  private DictionaryNode insertR(DictionaryNode curr, String s, String definition) {
    if (curr == null) {
      // the end of branch
      curr = new DictionaryNode(s, definition);
    }

    if (s.compareTo(curr.value) < 0) {
      // go left branch
      curr.left = insertR(curr.left, s, definition);
    } else if (s.compareTo(curr.value) > 0) {
      // go right branch
      curr.right = insertR(curr.right, s, definition);
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
  private DictionaryNode removeR(DictionaryNode curr, String s) {
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
        DictionaryNode leftmost = getLeftmost(curr.right);
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
  private DictionaryNode getLeftmost(DictionaryNode curr) {
    while (curr.left != null) {
      curr = curr.left;
    }
    return curr;
  }

  /**
   * To find the a node of specific value from the tree.
   * 
   * @param s the value
   * @return a node or null
   */
  public DictionaryNode get(String s) {
    return get(s, root);
  }

  /**
   * To find the a node of specific value from a starting node.
   * 
   * @param curr the starting node
   * @param s    the value
   * 
   * @return a node or null
   */
  public DictionaryNode get(String s, DictionaryNode curr) {
    if (curr == null) {
      return null;
    }

    if (s.compareTo(curr.value) < 0) {
      return get(s, curr.left);
    } else if (s.compareTo(curr.value) > 0) {
      return get(s, curr.right);
    } else {
      return curr;
    }
  }

  /**
   * Search a particular value.
   * 
   * @param s search specific value
   * @return true/false
   */
  public boolean search(String s) {
    return get(s) != null;
  }

  /**
   * To print the value and definition of a given word/phrase
   */
  public void printDictionaryItem(String s) {
    DictionaryNode n = get(s);
    System.out.println(n.value);
    System.out.println(n.definition);
  }

  /**
   * To print the value and definition of each node in alphabetical order
   * (printing
   * only the current node, and not the left and right subtrees).
   */
  public void printDictionary() {
    PrintCallback printer = (curr) -> {
      System.out.printf("%s\n", curr.value);
      System.out.printf("%s\n\n", curr.definition);
    };

    printR(root, printer);
  }

  /**
   * To print out the tree following an <b><i>in-order traversal</i></b> with
   * each value on a separate line.
   */
  public void print() {
    PrintCallback printer = (curr) -> System.out.printf(
        "Root: %s | Left: %s | Right: %s \n",
        curr.value,
        curr.left == null ? null : curr.left.value,
        curr.right == null ? null : curr.right.value);

    printR(root, printer);
  }

  /** A interface for Printout callback */
  public interface PrintCallback {
    public void print(DictionaryNode node);
  }

  /**
   * Private helper method for recursively printing the tree.
   * 
   * @param curr the starting node.
   */
  private void printR(DictionaryNode curr, PrintCallback printer) {
    if (curr == null) {
      return;
    }

    if (curr.left != null) {
      printR(curr.left, printer);
    }

    printer.print(curr);

    if (curr.right != null) {
      printR(curr.right, printer);
    }
  }
}