import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryCommandLine {
    public static void showAllWords(Dictionary dictionary) {
        ArrayList<Word> words = dictionary.getWords();
        words.sort(Comparator.comparing(Word::getWordTarget));

        System.out.println("No  | English          | Vietnamese");
        if (words.size() > 10000) {
            for (int i = 0; i < 9999; i++) {
                Word word = words.get(i);
                System.out.printf("%-4d| %-16s | %s%n", (i + 1), word.getWordTarget(), word.getWordExplain());
            }
            System.out.println("* Showed first 10000 words only *");
        } else {
            for (int i = 0; i < words.size(); i++) {
                Word word = words.get(i);
                System.out.printf("%-4d| %-16s | %s%n", (i + 1), word.getWordTarget(), word.getWordExplain());
            }
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
                            "[9] Export to file\n" +
                            "[10] Google Translate API\n");
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
                    System.out.println("Imported from file!");
                    break;
                case 9:
                    DictionaryManagement.dictionaryExportToFile(dictionary);
                    System.out.println("Exported to file!");
                    break;
                case 10:
                    try {
                        GoogleTranslateAPI.translate();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("Action not supported");
                    break;

            }
            System.out.print("New command?(Y/N): ");
            String cmd = sc.next();
            if (cmd.equalsIgnoreCase("N")) {
                running = false;
            }
        }
    }
}
