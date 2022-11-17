package DesignTicTacToe;

import java.utils.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players?");
        int numberOfPlayers = scanner.nextInt();
        System.out.println("How many bots?");
        int numberOfBots = scanner.nextInt();

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < numberOfBots; ++i) {
            System.out.println("Name of Bot + " + (i + 1));
            String botName = scanner.next();

            System.out.println("Symbol of Bot " + (i+1));
            Character character = scanner.next().charAt(0);

            System.out.println("Difficulty of Bot " + (i+1));
            String difficultylevel = scanner.next();
            BotDifficultyLevel botDifficultyLevel = BotDifficultyLevelFactory.getBotDifficultyLevelByName(difficultylevel);

            players.add(PlayerFactory.createBotPlayer(botName, character, botDifficultyLevel));
        }

        for (int i = 0; i < numberOfPlayers; ++i) {
            System.out.println("Name of Player + " + (i - numberOfBots + 1));
            String name = scanner.next();

            System.out.println("Symbol of Player " + (i - numberOfBots + 1));
            Character character = scanner.next().charAt(0);

            players.add(PlayerFactory.createHumanPlayer(name, character));
        }

        System.out.println("How many winning strategies?");
        Integer winningstrategiescount = scanner.nextInt();

        List<GameWinningStrategyName> gameWinningStrategyNames = new ArrayList<>();

        for (int i = 0; i< winningstrategiescount; ++i) {

            System.out.println("Winning type name " + i);
            gameWinningStrategyNames.add(GameWinningStrategyNameEnumFactory.getGameWinningStrategyEnumByName(scanner.next()));

        }

        Game game = Game.getBuilder().setGameWinningStrategies(gameWinningStrategyNames).setPlayers(players).build();

        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
            game.makeMove();
        }
    }
}