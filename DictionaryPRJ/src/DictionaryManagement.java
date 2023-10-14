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
    }
}
