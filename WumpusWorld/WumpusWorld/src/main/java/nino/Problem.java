package nino;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    // The labyrinth in which the problem occurs
    private Labyrinth labyrinth;
    // The starting state of the agent
    private State initialState;
    // The goal state (where the agent wants to go)
    private State goalState;

    // Constructor to initialize the problem with the given labyrinth
    public Problem(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
        // Get the starting position
        int[] start = labyrinth.getStartPosition();
        // Get the goal position
        int[] goal = labyrinth.getGoalPosition();
        // Set initial state
        this.initialState = new State(start[0], start[1]);
        // Set goal state
        this.goalState = new State(goal[0], goal[1]);
    }

    // Return the initial state of the problem
    public State getInitialState() {
        return initialState;
    }

    // Check if the current state is the goal state
    public boolean isGoal(State state) {
        return state.equals(goalState);
    }

    // Get all possible valid moves (successors) from the current node
    public List<Node> getSuccessors(Node node) {
        List<Node> successors = new ArrayList<>();
        // Define possible movement directions: up, down, left, right
        int[][] directions = {
                {-1, 0}, // up
                {1, 0},  // down
                {0, -1}, // left
                {0, 1}   // right
        };
        String[] actions = {"UP", "DOWN", "LEFT", "RIGHT"};

        // Generate all valid successors based on possible movements
        for (int i = 0; i < directions.length; i++) {
            int newRow = node.state.row + directions[i][0];
            int newCol = node.state.col + directions[i][1];

            // Check if the new position is safe (not a Wumpus or Pit)
            if (labyrinth.isSafe(newRow, newCol)) {
                State newState = new State(newRow, newCol);  // Create new state
                Node newNode = new Node(newState, node, actions[i], node.cost + 1);  // Create new node
                successors.add(newNode);  // Add the new node to the successors list
            }
        }

        return successors;  // Return the list of valid successors
    }
}
