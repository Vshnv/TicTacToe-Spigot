package io.github.vshnv.mc.tictactoe.game;

import java.util.UUID;

public final class Game {
    private final GamePlayer playerOne;
    private final GamePlayer playerTwo;
    private final GameBoard gameBoard;
    private GameState state;
    private int turnCount = 0;


    public Game(UUID p1, UUID p2) {
        this.playerOne = new GamePlayer(p1, 0);
        this.playerTwo = new GamePlayer(p2, 1);
        this.gameBoard = new GameBoard();
    }

    public GamePlayer getPlayerOne() {
        return playerOne;
    }

    public GamePlayer getPlayerTwo() {
        return playerTwo;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public GameState getState() {
        return state;
    }

    public GamePlayer getTurnPlayer() {
        return playerOne.isCurrentPlayer(turnCount) ? playerOne : playerTwo;
    }

    public GamePlayer getGamePlayer(UUID id) {
        if (playerOne.getId().equals(id)) {
            return playerOne;
        } else if (playerTwo.getId().equals(id)) {
            return playerTwo;
        }
        // Player not in game / Spectator ????
        return null;
    }

    public boolean tryMove(GamePlayer player, int row, int column) {
        if (gameBoard.isPositionAcquired(row, column)) return false;
        if (!player.isCurrentPlayer(turnCount)) return false;

        int positionValue = gameBoard.getPositionValue(row, column);
        player.addMove(positionValue);
        gameBoard.aquirePosition(row, column);

        recalculateGameState();

        turnCount++;
        return true;
    }

    private void recalculateGameState() {
        if (state != GameState.PLAYING) return;
        if (playerOne.hasWon()) {
            state = GameState.VICTORY_PLAYER_ONE;
        } else if (playerTwo.hasWon()) {
            state = GameState.VICTORY_PLAYER_TWO;
        } else if (gameBoard.isBoardFilled()) {
            state = GameState.TIE;
        }
    }
}
