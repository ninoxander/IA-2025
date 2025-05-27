package nino;

import nino.search.*;

public class Main {
    public static void main(String[] args) {
        // Initialize the labyrinth
        Labyrinth labyrinth = new Labyrinth();

        // Create the search problem using the labyrinth
        Problem problem = new Problem(labyrinth);

        // Run Breadth-First Search to find a path from start to goal
        Node result = HillClimbing.search(problem);

        // Displaying the result at the end
        if (result != null) {
            System.out.println("Path found:");
            BFS.printPath(result);
        } else {
            System.out.println("No path found.");
        }
    }
}