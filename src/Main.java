import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to not Jeopardy! You will be shown a board of 3 categories, " +
                "each with 5 questions. \nYou may choose any question you'd like by first selecting a " +
                "category, and then a point amount.");
        QuestionBoard.getInstance();
        Scoreboard.getInstance();
        String currentPlayer = "1";
        for (int i = 0; i < 15; i++) {
            System.out.println();
            System.out.println(Scoreboard.getInstance().getScore());
            System.out.println();
            System.out.println(QuestionBoard.getInstance().print());
            System.out.println("\nPlease enter a category");
            String category = scan.nextLine();
            if (category.equalsIgnoreCase("exit")) {
                break;
            }
            while (categoryNotValid(category)) {
                System.out.println("Please enter a category by name. Either 'Geography', 'History', or 'Music'");
                category = scan.nextLine();
            }
            System.out.println("Please choose a point amount.");
            int points;
            Trivia question;

            while (true) {
                if (scan.hasNextInt()) {
                    points = scan.nextInt();
                    if (isPointsInvalid(points)) {
                        System.out.println("Please enter either '100', '200', '300', '400', or '500'");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Please enter either '100', '200', '300', '400', or '500'");
                }
            }
            if (willThisWork(category, points)) {
                question = QuestionBoard.getInstance().getQuestion(category, points);
                QuestionBoard.getInstance().getQuestion(category, points).setValidQuestion(false);
                scan.nextLine();
            } else {
                continue;
            }
            System.out.println(question.getQuestion());
            System.out.println("\n");
            displayQuestions(question);
            String userAnswer = scan.nextLine();
            if (checkAnswer(userAnswer, question.getCorrectAnswer())) {
                awardScore(currentPlayer, question.getValue());
                System.out.println();
                System.out.println("\nCorrect answer!");
            } else {
                System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
                if (i != 14) {
                    System.out.println("You've lost your turn");
                }
                currentPlayer = changePlayer(currentPlayer);
            }
        }
        System.out.println(Scoreboard.getInstance().winner());
    }

    public static boolean categoryNotValid(String category) {
        if (category.equalsIgnoreCase("geography")) {
            return false;
        }
        if (category.equalsIgnoreCase("history")) {
            return false;
        }
        if (category.equalsIgnoreCase("music")) {
            return false;
        }
        return true;
    }

    public static boolean willThisWork(String category, int points) throws IOException {
        return QuestionBoard.getInstance().getQuestion(category, points).isQuestionValid();
    }

    public static boolean isPointsInvalid(int points) {
        return points != 100 && points != 200 && points != 300 && points != 400 && points != 500;
    }

    public static boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }

    public static void displayQuestions(Trivia question) {
        int placeToPutCorrectAnswer = (int)(1 + Math.random() * 3);
        boolean correctAnswerPrintedYet = false;
        for (int i = 0; i < 4; i++) {
            int j = i;

            if (i == placeToPutCorrectAnswer) {
                System.out.println("\t" + question.getCorrectAnswer());
                correctAnswerPrintedYet = true;
                continue;
            }
            if (correctAnswerPrintedYet) {
                j--;
            }
            System.out.println("\t" + question.getIncorrectAnswer(j));
        }
    }

    public static String changePlayer(String currentPlayer) {
        if (currentPlayer.equalsIgnoreCase("1")) {
            currentPlayer = "2";
        } else {
            currentPlayer = "1";
        }
        return currentPlayer;
    }

    public static void awardScore(String currentPlayer, int score) {
        if (currentPlayer.equalsIgnoreCase("1")) {
            Scoreboard.getInstance().setPlayer1(score);
        } else {
            Scoreboard.getInstance().setPlayer2(score);
        }
    }
}