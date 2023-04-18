public class Trivia {

    private final String id;
    private final String question;
    private final String correctAnswer;
    private final String[] incorrectAnswers;
    private int value;
    private boolean validQuestion;

    public Trivia(String id, String question, String difficulty, String correctAnswer, String[] incorrectAnswers) {
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = new String[] {
                incorrectAnswers[0],
                incorrectAnswers[1],
                incorrectAnswers[2],
                null
        };
        this.validQuestion = true;
        setValue(difficulty);
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

    public void setValue(String difficulty) {
        if (difficulty.equals("easy")) {
            this.value = 1;
        } else if (difficulty.equals("medium")) {
            this.value = 3;
        } else {
            this.value = 5;
        }
    }

    public void setValidQuestion(Boolean trueFalse) {
        this.validQuestion = trueFalse;
    }

    public boolean isQuestionValid() {
        return this.validQuestion;
    }

}
