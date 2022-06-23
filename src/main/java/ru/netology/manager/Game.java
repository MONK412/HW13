package ru.netology.manager;

import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int findByName(String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


    public int round(String playerName1, String playerName2) {
        int player1Num = findByName(playerName1);
        int player2Num = findByName(playerName2);
        if (player1Num == -1) {
            throw new NotRegisteredException("Игрок " + playerName1 + "не зарегистрирован");
        }
        if (player2Num == -1) {
            throw new NotRegisteredException("Игрок " + playerName2 + "не зарегистрирован");
        }
        int strength1 = players.get(player1Num).getStrength();
        int strength2 = players.get(player2Num).getStrength();
        if (strength1 > strength2) {
            return 1;
        }
        if (strength1 < strength2) {
            return 2;
        }
        return 0;
    }
}
