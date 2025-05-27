package nino.search;

import java.util.*;
import nino.Node;
import nino.State;
import nino.Problem;

import nino.search.utils.SearchUtils;

public class BFS {
    // Runs the Breadth-First Search algorithm and returns the goal node if found
    public static Node search(Problem problem) {
        Queue<Node> frontier = new LinkedList<>();
        Set<State> explored = new HashSet<>();

        Node startNode = new Node(problem.getInitialState(), null, null, 0);
        frontier.add(startNode);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();

            // Check if the goal state is reached
            if (problem.isGoal(current.state)) {
                return current;
            }

            explored.add(current.state);

            // Explore all valid successors (neighboring states)
            for (Node child : problem.getSuccessors(current)) {
                if (!explored.contains(child.state) && !SearchUtils.containsState(frontier, child.state)) {
                    frontier.add(child);
                }
            }
        }

        return null;  // Return null if no path is found
    }

    // Uses the shared method from SearchUtils to print the path
    public static void printPath(Node node) {
        SearchUtils.printPath(node);  // Delegates directly to the utility method
    }
}
