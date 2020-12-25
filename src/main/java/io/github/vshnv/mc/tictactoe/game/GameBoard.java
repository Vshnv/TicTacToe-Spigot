package io.github.vshnv.mc.tictactoe.game;

public final class GameBoard {
    private final int[][] board = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8}
    };

    public boolean isPositionAcquired(int row, int column) {
        validatePosition(row, column);
        return board[row][column] > 0;
    }

    public boolean isBoardFilled() {
        for (int[] rows : board) {
            for (int posValue : rows) {
                if (posValue > 0) return false;
            }
        }
        return true;
    }

    public boolean aquirePosition(int row, int column) {
        if (isPositionAcquired(row, column)) return false;
        setPositionValue(row, column, -1);
        return true;
    }

    public int getPositionValue(int row, int column) {
        validatePosition(row, column);
        return board[row][column];
    }

    private void setPositionValue(int row, int column, int value) {
        validatePosition(row, column);
        board[row][column] = value;
    }

    private void validatePosition(int row, int column) {
        if (row > 2 || column > 2) {
            throw new IllegalArgumentException(String.format("Invalid position provided: %d, %d", row, column));
        }
    }
}
