import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestScoreboard {
    @Before
    public void setup() {
        Scoreboard.getInstance().clear();
        Scoreboard.getInstance();
        Scoreboard.getInstance().setPlayer1(60);
        Scoreboard.getInstance().setPlayer1(10);
        Scoreboard.getInstance().setPlayer1(100);
        Scoreboard.getInstance().setPlayer2(100);
        Scoreboard.getInstance().setPlayer2(100);
    }

    @Test
    public void testSetPlayerScores() {
        Assert.assertEquals(170, Scoreboard.getInstance().getPlayer1());
        Assert.assertEquals(200, Scoreboard.getInstance().getPlayer2());
    }

    @Test
    public void testGetScore() {
        Assert.assertEquals("\n\tPlayer 1: 170\n\tPlayer 2: 200", Scoreboard.getInstance().getScore());
        Scoreboard.getInstance().setPlayer1(-10);
        Scoreboard.getInstance().setPlayer2(-10);
        Assert.assertEquals("\n\tPlayer 1: 160\n\tPlayer 2: 190", Scoreboard.getInstance().getScore());
    }

    @Test
    public void testGetWinner() {
        Assert.assertEquals("Player 2 wins with a score of 200. Player 1 lost with a score of 170", Scoreboard.getInstance().winner());
        Scoreboard.getInstance().setPlayer2(-31);
        Assert.assertEquals("Player 1 wins with a score of 170. Player 2 lost with a score of 169", Scoreboard.getInstance().winner());
    }
}