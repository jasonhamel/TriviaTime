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
        String category;
        int positionInArray = 0;
        for (int i = 100; i < 600; i += 100) {
            category = "geography";
            geography[positionInArray] = callAPI(i, category);
            geography[positionInArray].setValue(i);
            geography[positionInArray].setValidQuestion(true);
            category = "history";
            history[positionInArray] = callAPI(i, category);
            history[positionInArray].setValue(i);
            history[positionInArray].setValidQuestion(true);
            category = "music";
            music[positionInArray] = callAPI(i, category);
            music[positionInArray].setValue(i);
            music[positionInArray].setValidQuestion(true);
            positionInArray++;
        }
    }

    private static Trivia callAPI(int i, String category) throws IOException {
        String urlString = "https://the-trivia-api.com/api/questions?categories=";
        String betweenCategoryAndDifficulty = "&limit=1&difficulty=";
        String difficulty;
        if (i < 300) {
            difficulty = "easy";
        } else if (i < 500) {
            difficulty = "medium";
        } else {
            difficulty = "hard";
        }
        URL url = new URL(urlString + category + betweenCategoryAndDifficulty + difficulty);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        String inputLine = "";
        System.out.println(connection.getResponseCode());
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
        int placeInArray = Integer.parseInt(String.valueOf(String.valueOf(amount).charAt(0)));
        Trivia question = board.get(category)[placeInArray - 1];
        if (!question.isQuestionValid()) {
            return null;
        }
        return question;
    }

    public QuestionBoard clear() {
        instance = null;
        return instance;
    }
}