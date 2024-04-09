class PartOne {
  public static void main(String[] args) {
    System.out.println("Testing BST");

    StrBST bst = new StrBST();

    String[] insertOrder = new String[] { "C", "B", "A", "E", "D" };
    System.out.println("Inserting nodes: " + String.join(",", insertOrder));
    for (String str : insertOrder) {
      bst.insert(str);
    }
    printTree(bst);
    System.out.println();

    // searching
    testSearch(bst, "A");
    testSearch(bst, "F");
    System.out.println();

    bst.print();
    System.out.println();

    // removing
    testRemoving(bst, "B");
    System.out.println();
    testRemoving(bst, "C");
    System.out.println();
    testRemoving(bst, "A");
  }

  public static void printTree(StrBST bst) {
    System.out.println("Tree:");
    StrBSTPrinter.printNode(bst.root);
  }

  public static void testSearch(StrBST bst, String s) {
    System.out.println(s + " is in BST: " + bst.search(s));
  }

  public static void testRemoving(StrBST bst, String s) {
    System.out.printf("Removing node %s ...\n", s);
    bst.remove(s);
    printTree(bst);
  }

}