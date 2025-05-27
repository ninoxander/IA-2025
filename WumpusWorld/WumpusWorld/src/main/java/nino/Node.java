package nino;

public class Node {
    // The state represented by this node
    public State state;
    // The parent node that led to this state
    public Node parent;
    // The action taken to reach this state (e.g., "UP", "DOWN")
    public String action;
    // The cost to reach this state (for search algorithms)
    public int cost;

    // Constructor to create a new node with a state, parent, action, and cost
    public Node(State state, Node parent, String action, int cost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.cost = cost;
    }
}