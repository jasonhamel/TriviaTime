import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTrivia {
    Trivia trivia;
    Trivia trivia2;
    Trivia trivia3;

    @Before
    public void setup() {
        trivia = new Trivia("245325632543", "What's up?", 100, "Nothing", new String[] {
                "Something",
                "Everything",
                "Shut up"
        });
        trivia2 = new Trivia("245325632543", "What's up?", 300, "Nothing", new String[] {
                "Something",
                "Everything",
                "Shut up"
        });
        trivia3 = new Trivia("245325632543", "What's up?", 500, "Nothing", new String[] {
                "Something",
                "Everything",
                "Shut up"
        });
    }

    @Test
    public void testID() {
        Assert.assertEquals("245325632543", trivia.getId());
    }

    @Test
    public void testQuestion() {
        Assert.assertEquals("What's up?", trivia.getQuestion());
    }

    @Test
    public void testCorrectAnswer() {
        Assert.assertEquals("Nothing", trivia.getCorrectAnswer());
    }

    @Test
    public void testIncorrectAnswers() {
        Assert.assertEquals("Something", trivia.getIncorrectAnswer(0));
        Assert.assertEquals("Everything", trivia.getIncorrectAnswer(1));
        Assert.assertEquals("Shut up", trivia.getIncorrectAnswer(2));
    }

    @Test
    public void testIsQuestionValid() {
        Assert.assertTrue(trivia.isQuestionValid());
        trivia.setValidQuestion(false);
        Assert.assertFalse(trivia.isQuestionValid());
    }

    @Test
    public void testValue() {
        Assert.assertEquals(100, trivia.getValue());
        Assert.assertEquals(300, trivia2.getValue());
        Assert.assertEquals(500, trivia3.getValue());
    }
}
