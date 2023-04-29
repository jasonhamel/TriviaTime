public class Scoreboard {
    private int player1;
    private int player2;

    private static Scoreboard instance;

    private Scoreboard() {
        this.player1 = 0;
        this.player2 = 0;
    }

    public static Scoreboard getInstance() {
        if (instance == null) {
            instance = new Scoreboard();
        }
        return instance;
    }

    public int getPlayer1() {
        return player1;
    }

    public void setPlayer1(int player1) {
        this.player1 += player1;
    }

    public int getPlayer2() {
        return player2;
    }

    public void setPlayer2(int player2) {
        this.player2 += player2;
    }

    public String getScore() {
        return "\n\tPlayer 1: " + player1 + "\n\tPlayer 2: " + player2;
    }

    public String winner() {
        if (player1 > player2) {
            return "Player 1 wins with a score of " + player1 + ". Player 2 lost with a score of " + player2;
        } else if (player2 > player1) {
           return "Player 2 wins with a score of " + player2 + ". Player 1 lost with a score of " + player1;
        }
        return "Tie game!";
    }

    public void clear() {
        instance = null;
    }
}
