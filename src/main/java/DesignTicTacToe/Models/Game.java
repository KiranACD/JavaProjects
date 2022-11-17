package DesignTicTacToe.Models;

import DesignTicTacToe.Exceptions.DuplicateSymbolException;
import java.utils.List;
import java.utils.ArrayList;
import java.utils.HashSet;

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

    public void makeMove() {
        this.board.display();
        this.lastMovedPlayerIndex += 1;
        this.lastMovedPlayerIndex %= this.players.size();

        Move potentialMove = this.players.get(this.lastMovedPlayerIndex).makeMove(this.board);

        if (this.board.getCell(potentialMove.getRow(), potentialMove.getColumn()).getPlayer() != null) {
            System.out.println("Cell Filled!");
            return;
        }
        this.moves.add(potentialMove);
        this.board.getCell(potentialMove.getRow(), potentialMove.getColumn()).setPlayer(this.players.get(lastMovedPlayerIndex));
        
        this.filledCells += 1;

        for (GameWinningStrategy gameWinningStrategy: this.gameWinningStrategies) {
            if (gameWinningStrategy.checkVictory(this.board)) {
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
            this.players = players;
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
            game.board = new Board(players.size() - 1);
            game.lastMovedPlayerIndex = -1;

            return game;
        }
    }
}