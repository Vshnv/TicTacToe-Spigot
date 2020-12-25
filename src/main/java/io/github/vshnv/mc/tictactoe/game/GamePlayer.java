package io.github.vshnv.mc.tictactoe.game;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class GamePlayer {
    private final UUID id;
    private final int turnId;
    private final Set<Integer> moves;

    public GamePlayer(UUID id, int turnId) {
        this.id = id;
        this.turnId = turnId;
        this.moves = new HashSet<>();
    }


    public UUID getId() {
        return id;
    }

    public boolean isCurrentPlayer(int turn) {
        return turn % 2 == turnId;
    }

    public int getTurnId() {
        return turnId;
    }

    public Set<Integer> getMoves() {
        return moves;
    }

    public void addMove(int move) {
        this.moves.add(move);
    }

    public boolean hasMove(int move) {
        return this.moves.contains(move);
    }

    public boolean hasWon() {
        for (int i: moves) {
            for (int j: moves) {
                if (i == j) continue;
                if (moves.contains(15 - i - j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
