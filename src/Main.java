import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to not Jeopardy! You will be shown a board of 3 categories, " +
                "each with 5 questions. \nYou may choose any question you'd like by first selecting a " +
                "category, and then a point amount.");
        QuestionBoard.getInstance();
    }
}