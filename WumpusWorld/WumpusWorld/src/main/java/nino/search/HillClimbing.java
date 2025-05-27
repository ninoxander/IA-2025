package nino.search;

import java.util.*;
import nino.Node;
import nino.State;
import nino.Problem;

// Import utility functions
import nino.search.utils.SearchUtils;

public class HillClimbing {
    // Runs the Hill Climbing algorithm and returns the goal node if found
    public static Node search(Problem problem) {
        Node current = new Node(problem.getInitialState(), null, null, 0);

        while (true) {
            // Get successors of the current node
            List<Node> neighbors = problem.getSuccessors(current);

            // Select the best neighbor based on heuristic value
            Node next = getBestNeighbor(neighbors);

            // If there is no better neighbor, return current
            if (next == null || heuristic(next.state) <= heuristic(current.state)) {
                return problem.isGoal(current.state) ? current : null;
            }

            current = next;
        }
    }

    // Heuristic function (lower is better). This one uses Manhattan distance to goal.
    private static int heuristic(State state) {
        int goalX = 0;
        int goalY = 3;
        return Math.abs(state.getX() - goalX) + Math.abs(state.getY() - goalY);
    }

    // Select the neighbor with the lowest heuristic value
    private static Node getBestNeighbor(List<Node> neighbors) {
        Node best = null;
        int bestValue = Integer.MAX_VALUE;

        for (Node neighbor : neighbors) {
            int value = heuristic(neighbor.state);
            if (value < bestValue) {
                best = neighbor;
                bestValue = value;
            }
        }

        return best;
    }

    // Uses the shared method from SearchUtils to print the path
    public static void printPath(Node node) {
        SearchUtils.printPath(node);
    }
}
