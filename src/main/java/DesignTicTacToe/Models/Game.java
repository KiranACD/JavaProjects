package DesignTicTacToe.Models;

import DesignTicTacToe.Exceptions.DuplicateSymbolException;
import DesignTicTacToe.Strategies.winningstrategy.GameWinningStrategy;
import DesignTicTacToe.Factories.GameWinningStrategyFactory;
import DesignTicTacToe.Factories.PlayerFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Game {

    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private List<GameWinningStrategy> gameWinningStrategies;
    private int lastMovedPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;
    private int filledCells = 0;

    private Game() {}

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Board getBoard() {
        return this.board;
    }

    public List<Move> getMoves() {
        return this.moves;
    }

    public List<GameWinningStrategy> getGameWinningStrategies() {
        return this.gameWinningStrategies;
    }

    public int getLastMovedPlayerIndex() {
        return this.lastMovedPlayerIndex;
    }

    public Player getWinner() {
        return this.winner;
    }

    public void makeMove() {

        this.board.display();
        this.lastMovedPlayerIndex += 1;
        this.lastMovedPlayerIndex %= this.players.size();

        String name = this.players.get(this.lastMovedPlayerIndex).getName();
        System.out.println(name + "'s turn...");
        Move potentialMove = this.players.get(this.lastMovedPlayerIndex).makeMove(this.board);

        if (this.board.getCell(potentialMove.getRow(), potentialMove.getColumn()).getPlayer() != null) {
            System.out.println("Cell Filled!");
            return;
        }
        this.moves.add(potentialMove);
        this.board.getCell(potentialMove.getRow(), potentialMove.getColumn()).setPlayer(this.players.get(lastMovedPlayerIndex));
        
        this.filledCells += 1;

        for (GameWinningStrategy gameWinningStrategy: this.gameWinningStrategies) {
            if (gameWinningStrategy.checkVictory(this.board, potentialMove)) {
                this.gameStatus = GameStatus.ENDED;
                this.winner = this.players.get(lastMovedPlayerIndex);
                return;
            }
        }

        if (this.filledCells == (this.players.size() + 1) * (this.players.size() + 1)) {
            this.gameStatus = GameStatus.DRAW;
        }
    }

    public static class Builder {
        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;

        public Builder setPlayers(List<Player> players) {
            this.players = new ArrayList<>();
            for (Player player: players) {
                String name = player.getName();
                Character character = player.getSymbol().getCharacter();
                this.players.add(PlayerFactory.createHumanPlayer(name, character));
            }
            return this;
        }

        public Builder setGameWinningStrategies(List<GameWinningStrategyName> gameWinningStrategyNames) {


            this.gameWinningStrategies = new ArrayList<>();

            for (GameWinningStrategyName gameWinningStrategyName: gameWinningStrategyNames) {
                this.gameWinningStrategies.add(GameWinningStrategyFactory.getGameWinningStrategyByName(gameWinningStrategyName));

            }
            return this;
        }

        public Game build() {
            Set<Character> alreadyExistingCharacters = new HashSet<>();

            for (Player player: this.players) {
                if (alreadyExistingCharacters.contains(player.getSymbol().getCharacter())) {
                    throw new DuplicateSymbolException(player.getSymbol().getCharacter());
                }
                alreadyExistingCharacters.add(player.getSymbol().getCharacter());
            }

            Game game = new Game();
            game.gameStatus = GameStatus.IN_PROGRESS;
            game.gameWinningStrategies = this.gameWinningStrategies;
            game.players = this.players;
            game.moves = new ArrayList<>();
            game.board = new Board(this.players.size()+1);  
            game.lastMovedPlayerIndex = -1;
            game.winner = null;

            return game;
        }
    }
}