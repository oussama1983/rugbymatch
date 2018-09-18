package com.paulienvanalst.rugbymatch.oldfashioned;

import com.paulienvanalst.rugbymatch.team.NotImplementedException;
import com.paulienvanalst.rugbymatch.team.Position;

import java.util.Objects;

public class PlayerOLD {

    private final Position position;
    private final int backNumber;

    public PlayerOLD(Position position, int backNumber) {
        this.position = position;
        this.backNumber = backNumber;
    }


    public Position getPosition() {
        return position;
    }

    public int getBackNumber() {
        return backNumber;
    }

    public boolean isStarting() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerOLD player = (PlayerOLD) o;
        return backNumber == player.backNumber &&
                position == player.position;
    }

    @Override
    public int hashCode() {

        return Objects.hash(position, backNumber);
    }

    @Override
    public String toString() {
        return "Player{" +
                "position=" + position +
                ", backNumber=" + backNumber +
                '}';
    }
}
