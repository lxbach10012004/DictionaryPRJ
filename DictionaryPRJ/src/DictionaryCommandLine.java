import java.util.ArrayList;
import java.util.Comparator;

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
}
