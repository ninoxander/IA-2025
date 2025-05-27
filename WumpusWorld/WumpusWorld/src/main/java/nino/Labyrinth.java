package nino;

public class Labyrinth {
    private char[][] world;

    /*
        Symbols:
        W = Wumpus
        B = Start
        G = Gold
        P = Pit
        S = Stench
        E = Empty
        I = Agent start
     */
    public Labyrinth() {
        this.world = new char[][] {
                {'E', 'E', 'P', 'E'},
                {'E', 'W', 'G', 'E'},
                {'S', 'E', 'P', 'E'},
                {'I', 'E', 'E', 'E'}
        };
    }
    // Return the full grid
    public char[][] get() {
        return this.world;
    }
    // Return a cell value
    public char getCell(int row, int col) {
        if (isInBounds(row, col)) {
            return world[row][col];
        }
        return 'X';
    }
    // Check if cell is within grid border
    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < world.length && col >= 0 && col < world[0].length;
    }
    // Check if given cell is walkable
    public boolean isSafe(int row, int col) {
        if (!isInBounds(row, col)) return false;
        char cell = world[row][col];
        return cell != 'W' && cell != 'P';
    }
    // Get rows count
    public int getRows() {
        return world.length;
    }
    // Get cols count
    public int getCols() {
        return world[0].length;
    }
    // Get the starting point coordinates
    public int[] getStartPosition() {
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                if (world[i][j] == 'I') {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
    // Get gold position
    public int[] getGoalPosition() {
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                if (world[i][j] == 'G') {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}
