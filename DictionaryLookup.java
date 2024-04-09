import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryLookup {

  public static void main(String[] args) {
    System.out.println("Loading dictionary from file ...");
    String divideRegex = ": ";
    Scanner in = new Scanner(System.in);
    DictionaryBST dictionary = new DictionaryBST();
    ArrayList<String[]> lines = readDictionary("CS-Dictionary-small.txt", divideRegex);

    for (String[] line : lines) {
      dictionary.insert(line[0], line[1]);
    }

    System.out.println("\nWelcome to the Dictionary Lookup!\n");

    while (true) {
      printMenu();
      // Using Scanner for Getting Input from User
      String service = in.nextLine();

      switch (service) {
        // (1) Search for a word/phrase in the dictionary
        case "1":
          System.out.println("Searching the dictionary ...");
          System.out.println("Please enter a word/phrase to search for");
          String search = in.nextLine();
          if (search.length() > 0) {
            System.out.printf("The word/phrase '%s' exists in the dictionary: %b\r\n", search,
                dictionary.search(search));
          }
          break;

        // (2) Print a given word/phrase and it's definition
        case "2":
          System.out.println("Printing dictionary item ...");
          System.out.println("Please enter a word/phrase to print");
          String print = in.nextLine();
          if (print.length() > 0) {
            System.out.println();
            dictionary.printDictionaryItem(print);
          }
          break;

        // (3) Add a word/phrase and definition to the dictionary
        case "3":
          System.out.println("Adding item to the dictionary ...");
          String word = "", definition = "";

          // asking word - empty not allowed
          while (true) {
            System.out.println("Please enter a word/phrase");
            word = in.nextLine();

            if (word.length() > 0) {
              break;
            }
          }

          // asking definition - empty not allowed
          System.out.println("Thank you, now please enter the definition");
          while (true) {
            definition = in.nextLine();

            if (definition.length() > 0) {
              break;
            }

            System.out.println("please enter the definition");
          }

          dictionary.insert(word, definition);
          System.out.println("Thank you, that item has been inserted");
          break;

        // (4) Remove a word/phrase and definition from the dictionary
        case "4":
          System.out.println("Removing item to the dictionary ...");
          System.out.println("Please enter a word/phrase to remove");
          String remove = in.nextLine();
          dictionary.remove(remove);
          System.out.println("Thank you, that item has been removed");
          break;

        // (5) Print all of the words/phrases and their definitions, in alphabetical
        // order
        case "5":
          System.out.println("Printing the full dictionary ...");
          dictionary.printDictionary();
          break;

        // (6) Exit
        case "6":
          in.close();
          System.exit(0);
          break;
      }

      System.out.println("\nEnter any key to continue");
      in.nextLine();
    }
  }

  public static void printMenu() {
    System.out.println("Please enter a number to indicate what you would like to do\r\n" + //
        "        (1) Search for a word/phrase in the dictionary\r\n" + //
        "        (2) Print a given word/phrase and it's definition\r\n" + //
        "        (3) Add a word/phrase and definition to the dictionary\r\n" + //
        "        (4) Remove a word/phrase and definition from the dictionary\r\n" + //
        "        (5) Print all of the words/phrases and their definitions, in alphabetical order\r\n" + //
        "        (6) Exit");
    System.out.println("Please enter a number between 1 and 6:");
  }

  public static ArrayList<String[]> readDictionary(String pathname, String divideRegex) {
    ArrayList<String[]> lines = new ArrayList<String[]>();

    try {
      File myObj = new File(pathname);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();

        // only take the line which is not empty
        if (data.length() > 1) {
          // separate word and definition
          lines.add(data.split(divideRegex));
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return lines;
  }
}
