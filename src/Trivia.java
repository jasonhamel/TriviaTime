public class Trivia {

    private final String id;
    private final String question;
    private final String correctAnswer;
    private final String[] incorrectAnswers;
    private int value;
    private boolean validQuestion;

    public Trivia(String id, String question, int difficulty, String correctAnswer, String[] incorrectAnswers) {
        this.id = id;
        this.question = question;
        setValue(difficulty);
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = new String[] {
                incorrectAnswers[0],
                incorrectAnswers[1],
                incorrectAnswers[2],
                null
        };
        this.validQuestion = true;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getId() {
        return this.id;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public String getIncorrectAnswer(int position) {
        return incorrectAnswers[position];
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setValidQuestion(Boolean trueFalse) {
        this.validQuestion = trueFalse;
    }

    public boolean isQuestionValid() {
        return this.validQuestion;
    }

}
