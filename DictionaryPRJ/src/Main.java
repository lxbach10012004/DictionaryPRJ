public class Main {
    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();
        DictionaryManagement.insertFromFile(dictionary);
        DictionaryManagement.dictionarySearcher(dictionary);
        DictionaryCommandLine.showAllWords(dictionary);

    }
}