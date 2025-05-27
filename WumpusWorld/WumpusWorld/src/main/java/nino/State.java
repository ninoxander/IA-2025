package nino;

import java.util.Objects;

public class State {
    public int row;  // Row position in the labyrinth
    public int col;  // Column position in the labyrinth

    // Constructor to create a state with a specific row and column
    public State(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Getter for X (column)
    public int getX() {
        return col;
    }

    // Getter for Y (row)
    public int getY() {
        return row;
    }

    // Override equals to compare two State objects based on row and col
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof State)) return false;
        State other = (State) obj;
        return this.row == other.row && this.col == other.col;
    }

    // Override hashCode to generate a unique hash based on row and col
    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    // Return a string representation of the state in (row, col) format
    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
