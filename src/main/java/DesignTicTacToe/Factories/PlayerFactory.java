package DesignTicTacToe.Factories;

import DesignTicTacToe.Models.Player;
import DesignTicTacToe.Models.Bot;
import DesignTicTacToe.Models.Symbol;
import DesignTicTacToe.Models.BotDifficultyLevel;
import DesignTicTacToe.Models.PlayerType;

public class PlayerFactory {

    public static Player createHumanPlayer(String name, Character character) {
        Player player = new Player();
        player.setPlayerType(PlayerType.HUMAN);
        player.setName(name);
        player.setSymbol(new Symbol(character));

        return player;
    }

    public static Player createBotPlayer(String name, Character character, BotDifficultyLevel botDifficultyLevel) {
        Bot bot = new Bot(botDifficultyLevel);
        bot.setName(name);
        bot.setSymbol(new Symbol(character));
        bot.setPlayerType(PlayerType.BOT);

        return bot;
    }
}