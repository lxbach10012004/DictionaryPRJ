import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DictionaryManagement {
    public static void insertFromCommandLine(Dictionary dictionary) {
        System.out.print("Number of words: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Word target: ");
            String word_target = sc.nextLine();
            System.out.print("Word explain: ");
            String word_explain = sc.nextLine();
            dictionary.addWord(word_target, word_explain);
        }
        System.out.println(n + " words added!");
    }
    public static void insertFromFile(Dictionary dictionary) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("documents/dictionaries.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] words = line.split("\t");
                String word_target = words[0];

                String word_explain;
                if (words.length <= 1) {
                    word_explain = "'CHƯA ĐƯỢC ĐỊNH NGHĨA'";
                } else {
                    word_explain = words[1];
                }


                dictionary.addWord(word_target, word_explain);

                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void dictionaryLookup(Dictionary dictionary) {
        ArrayList<Word> words = dictionary.getWords();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Search for a word (Enter '0' to exit): ");
            String line = sc.nextLine().trim();

            if (line.equals("0")) {
                System.out.println("Exiting...");
                break;
            }

            boolean found = false;
            for (Word word : words) {
                if (word.getWordTarget().equalsIgnoreCase(line)) {
                    System.out.println("Word: " + word.getWordTarget());
                    System.out.println("Explanation: " + word.getWordExplain());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Word not found!");
            }
        }
    }

    public static void dictionaryAddWord(Dictionary dictionary) {
        insertFromCommandLine(dictionary);
    }

    public static void dictionaryModifyWord(Dictionary dictionary) {
        ArrayList<Word> words = dictionary.getWords();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Modify a word (Enter '0' to exit): ");
            String line = sc.nextLine().trim();

            if (line.equals("0")) {
                System.out.println("Exiting...");
                break;
            }

            boolean found = false;
            for (Word word : words) {
                if (word.getWordTarget().equalsIgnoreCase(line)) {
                    System.out.println("Old explanation: " + word.getWordExplain());
                    System.out.print("New explanation: ");
                    word.setWordExplain(sc.nextLine());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Word not found!");
            }
        }
        dictionary.setWords(words);
    }

    public static void dictionaryDeleteWord(Dictionary dictionary) {
        ArrayList<Word> words = dictionary.getWords();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Delete a word (Enter '0' to exit): ");
            String line = sc.nextLine().trim();

            if (line.equals("0")) {
                System.out.println("Exiting...");
                break;
            }

            boolean found = false;
            for (Word word : words) {
                if (word.getWordTarget().equalsIgnoreCase(line)) {
                    System.out.println("Word: '" + word.getWordTarget() + "' deleted!");
                    words.remove(word);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Word not found!");
            }
        }
        dictionary.setWords(words);
    }

    public static void dictionarySearcher(Dictionary dictionary) {
        ArrayList<Word> words = dictionary.getWords();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Search for words start with (Enter '0' to exit): ");
            String line = sc.nextLine().trim();

            if (line.equals("0")) {
                System.out.println("Exiting...");
                break;
            }

            boolean found = false;
            boolean first = true;
            for (Word word : words) {
                if (word.getWordTarget().toLowerCase().startsWith(line.toLowerCase())) {
                    if(first) {
                        System.out.print(word.getWordTarget());
                        first = false;
                        found = true;
                    } else {
                        System.out.print(", " + word.getWordTarget());
                        found = true;
                    }
                }
            }
            System.out.println();
            if (!found) {
                System.out.println("No word found!");
            }
        }
    }

    public static void dictionaryExportToFile(Dictionary dictionary) {
        try {
            FileWriter writer = new FileWriter("documents/exportedDictionaries.txt");
            BufferedWriter line = new BufferedWriter(writer);

            ArrayList<Word> words = dictionary.getWords();
            for (Word word : words) {
                line.write(word.getWordTarget() + "\t" + word.getWordExplain());
                line.newLine();
            }

            line.close();
            writer.close();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
