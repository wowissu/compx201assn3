class main {
  public static void main(String[] args) {
    Stack MyStack = new Stack();

    // push
    MyStack.push("1");
    MyStack.push("2");
    MyStack.push("3");
    MyStack.push("4");
    MyStack.push("5");
    MyStack.dump();

    // length
    System.out.println("length of Stack:" + MyStack.length());

    // peek
    String peek = MyStack.peek();
    System.out.println("Peek value:" + peek);

    // pop
    System.out.println("Pop value:" + MyStack.pop());
    MyStack.dump();
    System.out.println("Pop value:" + MyStack.pop());
    MyStack.dump();
    System.out.println("Pop value:" + MyStack.pop());
    MyStack.dump();
    System.out.println("Pop value:" + MyStack.pop());
    MyStack.dump();
    System.out.println("Pop value:" + MyStack.pop());
    MyStack.dump();

    // isEmpty
    System.out.println("isEmpty:" + MyStack.isEmpty());
  }
}