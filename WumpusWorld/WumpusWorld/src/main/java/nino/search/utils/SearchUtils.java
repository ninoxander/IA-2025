package nino.search.utils;

import java.util.*;
import nino.Node;
import nino.State;

public class SearchUtils {

    // Prints the path from the initial state to the goal state
    public static void printPath(Node node) {
        List<String> path = new ArrayList<>();
        while (node != null) {
            path.add(node.state.toString());
            node = node.parent;
        }
        Collections.reverse(path);
        for (String step : path) {
            System.out.println(step);
        }
    }

    // Generic method to check if a collection of nodes contains a specific state
    public static boolean containsState(Collection<Node> collection, State state) {
        for (Node node : collection) {
            if (node.state.equals(state)) return true;
        }
        return false;
    }
}
