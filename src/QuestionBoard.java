import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class QuestionBoard {

    private static QuestionBoard instance = null;
    private final HashMap<String, Trivia[]> board;
    private final Trivia[] geography;
    private final Trivia[] history;
    private final Trivia[] music;

    private QuestionBoard() throws IOException {
        board = new HashMap<>();
        geography = new Trivia[5];
        history = new Trivia[5];
        music = new Trivia[5];
        populateBoard();
        board.put("Geography", geography);
        board.put("History", history);
        board.put("Music", music);
    }

    public static QuestionBoard getInstance() throws IOException {
        if (instance == null) {
            instance = new QuestionBoard();
        }
        return instance;
    }

    private void populateBoard() throws IOException {
        String difficulty;
        String category;
        for (int i = 0; i < 5; i++) {
            if (i <= 1) {
                difficulty = "easy";
            } else if (i <= 3) {
                difficulty = "medium";
            } else {
                difficulty = "hard";
            }
            category = "geography";
            geography[i] = callAPI(difficulty, category);
            geography[i].setValue(difficulty);
            geography[i].setValidQuestion(true);
            category = "history";
            history[i] = callAPI(difficulty, category);
            history[i].setValue(difficulty);
            history[i].setValidQuestion(true);
            category = "music";
            music[i] = callAPI(difficulty, category);
            music[i].setValue(difficulty);
            music[i].setValidQuestion(true);
        }
    }

    private static Trivia callAPI(String difficulty, String category) throws IOException {
        String urlString = "https://the-trivia-api.com/api/questions?categories=";
        String betweenCategoryAndDifficulty = "&limit=1&difficulty=";
        URL url = new URL(urlString + category + betweenCategoryAndDifficulty + difficulty);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        String inputLine = "";

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            inputLine = in.readLine();
            inputLine = inputLine.substring(1, inputLine.length() - 1);
            in.close();
        } else {
            System.out.println("Server error");
            System.exit(0);
        }

        Gson gson = new Gson();
        return gson.fromJson(inputLine, Trivia.class);
    }

    public Trivia getQuestion(String category, int amount) {
        Trivia question = board.get(category)[amount - 1];
        if (!question.isQuestionValid()) {
            return null;
        }
        question.setValidQuestion(false);
        return question;
    }
}