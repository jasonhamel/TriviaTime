import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestQuestionBoard {
    @Before
    public void setup() throws IOException {
        QuestionBoard.getInstance();
    }

    @Test
    public void testEmpty() throws IOException {
        Assert.assertNotNull(QuestionBoard.getInstance());
    }

    @Test
    public void testGetQuestion() throws IOException {
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Geography", 1));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Geography", 2));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Geography", 3));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Geography", 4));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Geography", 5));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("History", 1));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("History", 2));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("History", 3));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("History", 4));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("History", 5));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Music", 1));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Music", 2));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Music", 3));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Music", 4));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Music", 5));
    }

    @Test
    public void testValidity() throws IOException {
        Trivia trivia1 = QuestionBoard.getInstance().getQuestion("Music", 1);
        Trivia trivia2 = QuestionBoard.getInstance().getQuestion("Music", 1);
        Trivia trivia3 = QuestionBoard.getInstance().getQuestion("Music", 1);
        Trivia trivia4 = QuestionBoard.getInstance().getQuestion("Music", 1);
        Assert.assertNotNull(trivia1);
        Assert.assertNull(trivia2);
        Assert.assertNull(trivia3);
        Assert.assertNull(trivia4);
    }
}
