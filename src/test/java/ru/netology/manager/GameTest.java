package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;

public class GameTest {
    private Game game = new Game();

    Player player1 = new Player(17, "Alex", 38);
    Player player2 = new Player(3, "Max", 62);
    Player player3 = new Player(18, "Kate", 14);
    Player player4 = new Player(10, "Nick", 14);

    @Test
    public void notRegisteredPlayer1() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Oleg", "Nick");
        });
    }

    @Test
    public void notRegisteredPlayer2() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Alex", "Rustam");
        });
    }

    @Test
    public void shouldWinPlayer1() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        int actual = game.round("Max", "Alex");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayer2() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        int actual = game.round("Nick", "Alex");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        int actual = game.round("Nick", "Kate");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
}
