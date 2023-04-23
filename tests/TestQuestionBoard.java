import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestQuestionBoard {

    String question = "";
    @Before
    public void setup() throws IOException {
        QuestionBoard.getInstance();
        question = QuestionBoard.getInstance().getQuestion("Geography", 100).getQuestion();
    }

    @Test
    public void testEmpty() throws IOException {
        Assert.assertNotNull(QuestionBoard.getInstance());
        Assert.assertEquals(question, QuestionBoard.getInstance().getQuestion("Geography", 100).getQuestion());
    }

    @Test
    public void testGetQuestion() throws IOException {
        QuestionBoard.getInstance().getQuestion("Music", 100).setValidQuestion(true);
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Geography", 100));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Geography", 200));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Geography", 300));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Geography", 400));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Geography", 500));
        QuestionBoard.getInstance().getQuestion("History", 100).setValidQuestion(true);
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("History", 100));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("History", 200));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("History", 300));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("History", 400));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("History", 500));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Music", 100));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Music", 200));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Music", 300));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Music", 400));
        Assert.assertNotNull(QuestionBoard.getInstance().getQuestion("Music", 500));
        Assert.assertEquals(question, QuestionBoard.getInstance().getQuestion("Geography", 100).getQuestion());
    }

    @Test
    public void testValidity() throws IOException {
        Trivia trivia1 = QuestionBoard.getInstance().getQuestion("Music", 100);
        QuestionBoard.getInstance().getQuestion("Music", 100).setValidQuestion(false);
        Trivia trivia2 = QuestionBoard.getInstance().getQuestion("Music", 100);
        Trivia trivia3 = QuestionBoard.getInstance().getQuestion("History", 100);
        QuestionBoard.getInstance().getQuestion("History", 100).setValidQuestion(false);
        Trivia trivia4 = QuestionBoard.getInstance().getQuestion("History", 100);
        Assert.assertNotNull(trivia1);
        Assert.assertNull(trivia2);
        Assert.assertNotNull(trivia3);
        Assert.assertNull(trivia4);
        Assert.assertEquals(question, QuestionBoard.getInstance().getQuestion("Geography", 100).getQuestion());
    }

    @Test
    public void testClear() throws IOException {
        Assert.assertNull(QuestionBoard.getInstance().clear());
    }
}
