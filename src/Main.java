import TrieImple.Trie;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTrie Menu:");
            System.out.println("1. Insert Word");
            System.out.println("2. Prefix Search");
            System.out.println("3. Exact Search");
            System.out.println("4. Universal Search");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter word to insert: ");
                    String word = scanner.nextLine().toLowerCase();
                    trie.insert(word);
                    System.out.println("Word inserted: " + word);
                    break;

                case 2:
                    System.out.print("Enter prefix to search: ");
                    String prefix = scanner.nextLine().toLowerCase();
                    ArrayList<String> results = trie.preSearch(prefix);
                    if (results.isEmpty()) {
                        System.out.println("No matching results found.");
                    } else {
                        System.out.println("Words found with prefix '" + prefix + "': " + results);
                    }
                    break;

                case 3:
                    System.out.println("Enter word to search: ");
                    String exact  = scanner.nextLine().toLowerCase();
                    if(trie.exactSearch(exact)){
                        System.out.println("Word Found!!");
                    }
                    else{
                        System.out.println("No matching results found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter word to search: ");
                    String universal  = scanner.nextLine().toLowerCase();
                    ArrayList<String> ans = trie.universalSearch(universal);
                    if(ans.isEmpty()){
                        System.out.println("No matching results found.");
                    }
                    else{
                        System.out.println("Words found with containing"+universal +" substring" + ans);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
