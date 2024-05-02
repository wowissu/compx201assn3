import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for the Stack class.
 */
public class StackUnitTest {

  /**
   * Test creating stack instance.
   */
  @Test
  @DisplayName("Test creating stack instance")
  public void test() {
    Stack stack = new Stack();

    Assertions.assertEquals("Stack", stack.getClass().getSimpleName());
  }

  /**
   * Test the push() method.
   */
  @Test
  @DisplayName("Test Push Operations")
  public void testPush() {
    Stack stack = new Stack();
    stack.push("A");
    stack.push("B");
    stack.push("C");

    Assertions.assertEquals(3, stack.length());
  }

  /**
   * Test the push() method.
   */
  @Test
  @DisplayName("Test Push Operations (edge case: only one item)")
  public void testPushOnlyOne() {
    Stack stack = new Stack();
    stack.push("A");

    Assertions.assertEquals(1, stack.length());
  }

  /**
   * Test the pop() method.
   */
  @Test
  @DisplayName("Test Pop Operation")
  public void testPop() {
    Stack stack = new Stack();
    stack.push("A");
    stack.push("B");
    stack.push("C");

    Assertions.assertEquals("C", stack.pop());
    Assertions.assertEquals("B", stack.pop());
    Assertions.assertEquals("A", stack.pop());
    Assertions.assertNull(stack.pop()); // Stack should be empty now
  }

  /**
   * Test the pop() when stack is empty.
   */
  @Test
  @DisplayName("Test Pop Operation (edge case: stack is empty)")
  public void testPopWhenIsAlreadyEmpty() {
    Stack stack = new Stack();
    Assertions.assertNull(stack.pop()); // Should return null anyway
  }

  /**
   * Test the peek() method.
   */
  @Test
  @DisplayName("Test Peek Operation")
  public void testPeek() {
    Stack stack = new Stack();
    stack.push("X");
    stack.push("Y");
    stack.push("Z");

    Assertions.assertEquals("Z", stack.peek());
    stack.pop();
    Assertions.assertEquals("Y", stack.peek());
    stack.pop();
    Assertions.assertEquals("X", stack.peek());
    stack.pop();
    Assertions.assertNull(stack.peek()); // Stack should be empty now
  }

  /**
   * Test the peek() method when stack is empty.
   */
  @Test
  @DisplayName("Test Peek Operation (edge case: stack is empty)")
  public void testPeekWhenEmpty() {
    Stack stack = new Stack();
    Assertions.assertTrue(stack.isEmpty());
    Assertions.assertNull(stack.peek()); // Stack should be empty now
  }

  /**
   * Test the isEmpty() method.
   */
  @Test
  @DisplayName("Test IsEmpty Method")
  public void testIsEmpty() {
    Stack stack = new Stack();
    Assertions.assertTrue(stack.isEmpty());

    stack.push("1");
    Assertions.assertFalse(stack.isEmpty());

    stack.pop();
    Assertions.assertTrue(stack.isEmpty());
  }

  /**
   * Test the length() method.
   */
  @Test
  @DisplayName("Test Length Method")
  public void testLength() {
    Stack stack = new Stack();
    Assertions.assertEquals(0, stack.length());

    stack.push("One");
    stack.push("Two");
    stack.push("Three");
    Assertions.assertEquals(3, stack.length());

    stack.pop();
    Assertions.assertEquals(2, stack.length());
    stack.pop();
    Assertions.assertEquals(1, stack.length());
    stack.pop();
    Assertions.assertEquals(0, stack.length());
  }

  /**
   * Test the dump() method.
   */
  @Test
  @DisplayName("Test Dump Method")
  public void testDump() {
    Stack stack = new Stack();
    stack.push("Apple");
    stack.push("Banana");
    stack.push("Orange");

    // Redirect standard output to a string buffer for comparison
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    stack.dump();
    Assertions.assertEquals("Orange->Banana->Apple->", outContent.toString());

    // Reset standard output
    System.setOut(System.out);
  }

  /**
   * Test the dump() method when stack is empty.
   */
  @Test
  @DisplayName("Test Dump Method (edge case: stack is empty)")
  public void testDumpWhenEmpty() {
    Stack stack = new Stack();

    // Redirect standard output to a string buffer for comparison
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    stack.dump();
    Assertions.assertEquals("", outContent.toString());

    // Reset standard output
    System.setOut(System.out);
  }

  /**
   * Test the dump() method when stack is empty.
   */
  @Test
  @DisplayName("Test Dump Method (edge case: stack has only one item)")
  public void testDumpWhenOnlyOne() {
    Stack stack = new Stack();
    stack.push("Apple");

    // Redirect standard output to a string buffer for comparison
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    stack.dump();
    Assertions.assertEquals("Apple->", outContent.toString());

    // Reset standard output
    System.setOut(System.out);
  }
}
