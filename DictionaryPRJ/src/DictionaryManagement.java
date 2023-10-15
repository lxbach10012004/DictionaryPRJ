import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    }
    public static void insertFromFile(Dictionary dictionary) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\Documents\\GitHub\\DictionaryPRJ\\DictionaryPRJ\\documents\\dictionaries.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] words = line.split("\t");
                String word_target = words[0];
                String word_explain = words[1];

                dictionary.addWord(word_target, word_explain);

                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
