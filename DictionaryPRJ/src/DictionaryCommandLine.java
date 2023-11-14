import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryCommandLine {
    public static void showAllWords(Dictionary dictionary) {
        ArrayList<Word> words = dictionary.getWords();
        words.sort(Comparator.comparing(Word::getWordTarget));

        System.out.println("No  | English | Vietnamese");
        for (int i = 0; i < words.size(); i++) {
            Word word = words.get(i);
            System.out.printf("%-4d| %-8s| %s%n", (i + 1), word.getWordTarget(), word.getWordExplain());
        }
    }

    public static void dictionaryBasic(Dictionary dictionary) {
        DictionaryManagement.insertFromCommandLine(dictionary);
        showAllWords(dictionary);
    }

    public static void dictionaryAdvanced(Dictionary dictionary) {
        boolean running = true;
        while (running) {
            System.out.print(
                    "Welcome to My Application!\n" +
                            "[0] Exit\n" +
                            "[1] Add\n" +
                            "[2] Remove\n" +
                            "[3] Update\n" +
                            "[4] Display\n" +
                            "[5] Lookup\n" +
                            "[6] Search\n" +
                            "[7] Game\n" +
                            "[8] Import from file\n" +
                            "[9] Export to file\n");
            System.out.print("Your action: ");
            Scanner sc = new Scanner(System.in);
            int operation = sc.nextInt();
            switch (operation) {
                case 0:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                case 1:
                    DictionaryManagement.dictionaryAddWord(dictionary);
                    break;
                case 2:
                    DictionaryManagement.dictionaryDeleteWord(dictionary);
                    break;
                case 3:
                    DictionaryManagement.dictionaryModifyWord(dictionary);
                    break;
                case 4:
                    showAllWords(dictionary);
                    break;
                case 5:
                    DictionaryManagement.dictionaryLookup(dictionary);
                    break;
                case 6:
                    DictionaryManagement.dictionarySearcher(dictionary);
                    break;
                case 7:
                    Game.play();
                    break;
                case 8:
                    DictionaryManagement.insertFromFile(dictionary);
                    break;
                case 9:
                    DictionaryManagement.dictionaryExportToFile(dictionary);
                    break;
                default:
                    System.out.println("Action not supported");
                    break;

            }
        }
    }
}
