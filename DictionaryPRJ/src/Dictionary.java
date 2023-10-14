import java.util.ArrayList;
import java.util.Comparator;

public class Dictionary {
    private ArrayList<Word> words;

    public Dictionary() {
        words = new ArrayList<>();
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public void addWord(String word_target, String word_explain) {
        words.add(new Word(word_target, word_explain));
    }

}
