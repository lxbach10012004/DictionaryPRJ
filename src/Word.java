public class Word {
    private String word_target;
    private String word_explain;

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public String getWordTarget() {
        return new String(word_target);
    }

    public void setWordTarget(String word_target) {
        this.word_target = word_target;
    }

    public String getWordExplain() {
        return new String(word_explain);
    }

    public void setWordExplain(String word_explain) {
        this.word_explain = word_explain;
    }

    @Override
    public String toString() {
        return word_target + ": " + word_explain;
    }
}
