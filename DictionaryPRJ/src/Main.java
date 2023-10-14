public class Main {
    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();
        DictionaryManagement.insertFromCommandLine(dictionary);
        DictionaryCommandLine.showAllWords(dictionary);
    }
}