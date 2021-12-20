// C343 Summer 2020
//
// a simple implementation for graphs with adjacency lists

// C343 / Summer 2020
// Homework - 06
// Started : July 25, 2020 13:01, Turned in July 27, 2020 16:11
// Clare Tidmarsh, cmtidmar

import java.util.*;


public class AdjGraph implements Graph {

    // is it a directed graph (true or false) :
    private boolean digraph;

    private int totalNodes;
    // all the nodes in the graph:
    private Vector<String> nodeList;

    private int totalEdges;
    // all the adjacency lists, one for each node in the graph:
    private Vector<LinkedList<Integer>> adjList;

    private Vector<LinkedList<Integer>> L;

    //private Vector

    // every visited node:
    private Vector<Boolean> visited;

    // list of nodes pre-visit:
    private Vector<Integer> nodeEnum;

    public AdjGraph() {
        init();
    }

    public AdjGraph(boolean ifdigraph) {
        init();
        digraph = ifdigraph;
    }

    public void init() {
        nodeList = new Vector<String>();
        adjList = new Vector<LinkedList<Integer>>();
        visited = new Vector<Boolean>();
        nodeEnum = new Vector<Integer>();
        totalNodes = totalEdges = 0;
        digraph = false;
        L = new Vector<LinkedList<Integer>>();
    }

    // set vertices:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes++;
        }
    }

    // add a vertex:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
        totalNodes++;
    }

    public int getNode(String node) {
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.elementAt(i).equals(node)) return i;
        }
        return -1;
    }

    // return the number of vertices:
    public int length() {
        return nodeList.size();
    }

    // add edge from v1 to v2:
    public void setEdge(int v1, int v2, int weight) {
        LinkedList<Integer> tmp = adjList.elementAt(v1);
        if (adjList.elementAt(v1).contains(v2) == false) {
            tmp.add(v2);
            adjList.set(v1, tmp);
            totalEdges++;
        }
    }

    public void setEdge(String v1, String v2, int weight) {
        if ((getNode(v1) != -1) && (getNode(v2) != -1)) {
            // add edge from v1 to v2:
            setEdge(getNode(v1), getNode(v2), weight);
            // for undirected graphs, add edge from v2 to v1 as well:
            if (digraph == false) {
                setEdge(getNode(v2), getNode(v1), weight);
            }
        }
    }

    // keep track whether a vertex has been visited or not,
    //    for graph traversal purposes:
    public void setVisited(int v) {
        visited.set(v, true);
        nodeEnum.add(v);
    }

    public boolean ifVisited(int v) {
        return visited.get(v);
    }


    // clean up before traversing the graph:
    public void clearWalk() {
        nodeEnum.clear();
        for (int i = 0; i < nodeList.size(); i++)
            visited.set(i, false);
    }

    public void walk(String method) {
        clearWalk();
        // traverse the graph:
        for (int i = 0; i < nodeList.size(); i++) {
            if (ifVisited(i) == false) {
                if (method.equals("BFS")) {
                    BFS(i);      // i is the start node
                } else if (method.equals("DFS")) {
                    DFS(i); // i is the start node
                } else {
                    System.out.println("unrecognized traversal order: " + method);
                    System.exit(0);
                }
            }
        }
        System.out.println(method + ":");
        displayEnum();
    }


    public void DFS(int v) {
        setVisited(v);
        LinkedList<Integer> neighbors = adjList.elementAt(v);
        for (int i = 0; i < neighbors.size(); i++) {
            int v1 = neighbors.get(i);
            if (ifVisited(v1) == false) DFS(v1);
        }
    }

    public void BFS(int s) {
        ArrayList<Integer> toVisit = new ArrayList<Integer>();
        toVisit.add(s);
        while (toVisit.size() > 0) {
            int v = toVisit.remove(0);   // first-in, first-visit
            setVisited(v);
            LinkedList<Integer> neighbors = adjList.elementAt(v);
            for (int i = 0; i < neighbors.size(); i++) {
                int v1 = neighbors.get(i);
                if ((ifVisited(v1) == false) && (toVisit.contains(v1) == false)) {
                    toVisit.add(v1);
                }
            }
        }
    }

    public void display() {
        System.out.println("total nodes: " + totalNodes);
        System.out.println("total edges: " + totalEdges);
    }

    public void displayEnum() {
        for (int i = 0; i < nodeEnum.size(); i++) {
            System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
        }
        System.out.println();
    }

    // Homework - 06 TODO:
//    Implement the topological sort algorithm using a queue instead of recursion as described
//    in the reading assignment PDF document.
//    Write a method named topologicalSortWithQueue() that computes and prints out a list of
//    topologically sorted nodes from a given AdjGraph instance.

    //@Override

    /**
     * Helper function to get the neigbors of an element in a list
     * @param v element in a list
     * @return the neigbors of the element, v, in a linked list
     */
    public LinkedList<Integer> getNeighbors(int v) {
        return adjList.get(v);
    }

    void topologicalSortWithQueue() {
        LinkedList<Integer> L = new LinkedList<>(); // L ←  a list that will contain sorted vertices
        ArrayList<Integer> C = new ArrayList(); // C ←  a list containing indegrees for each of the vertices
        LinkedList<Integer> Q = new LinkedList(); // Q ←  a queue containing eligible vertices (vertices that have no incoming edges)
        boolean Queue = Q.isEmpty();

        walk("BFS");
        System.out.println();
        walk("DFS");

        while (!Queue) { // while Q is nonempty do
            int u = Q.poll(); // remove a vertex u from Q (https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html : poll - "Retrieves and removes the head of this queue, or returns null if this queue is empty.")
            L.add(u); // add u to the end of L
            for (int v : getNeighbors(L.get(u))) { // for each neighbor v of u do
                int decrement = C.get(v);
                decrement--; // decrement C[v] by one
                if (C.get(v) == 0) { // if C[v] == 0 (v has no other incoming edges)
                    Q.add(v); //  push v to Q (queue of eligible vertices)
                }
            }
        }
        for (int i = 0; i <= L.size(); i++) { // if L contains all the vertices
            for (int j = i; j < Q.size(); j++) {
                if (L.get(i).equals(Q.get(j))) { // iterates through L and Q, if L[i] == Q[j]
                    System.out.println("L is the solution");  //  L is the solution
                } else {
                    System.out.println("Solution not found"); // else, solution not found
                }
           }
        }
    }

    // Homework - 06 TODO:
//    Write a main() method in AdjGraph.java, where you need define three non-trivial graphs,
//    and test your topologicalSortWithQueue() method on each one of those graphs. In particular,
//    you should test that your code works for the graph shown in Figure 11.14 in the reading assignment PDF
//    document, and that it provides the correct solution to the topological sorting of the given graph
public static void main(String[] args) {
    System.out.println("Example 1:");
    AdjGraph ex1 = new AdjGraph();
    String[] vertices = {"A", "B", "C", "D", "E", "F", "G"};
    ex1.setVertices(vertices); // public void setVertices(String[] nodes)
    ex1.setEdge("A", "B ", 1);
    ex1.setEdge("B", "C ", 3);
    ex1.setEdge("B", "D ", 4);
    ex1.setEdge("C", "D ", 4);
    ex1.setEdge("D", "E ", 10);
    ex1.setEdge("E", "A", 20);
    ex1.setEdge("E", "F", 15);
    ex1.setEdge("F", "G", 2);
    ex1.setEdge("G", "C", 7);
    ex1.display();
    ex1.topologicalSortWithQueue();

    System.out.println();
    System.out.println("Example 2:");
    AdjGraph ex2 = new AdjGraph();
    String[] vertices2 = {"A", "B", "C", "D", "E"};
    ex2.setVertices(vertices2);
    ex2.setEdge("A", "B", 3);
    ex2.setEdge("A", "C", 5);
    ex2.setEdge("B", "D", 2);
    ex2.setEdge("D", "E", 7);
    ex2.setEdge("E", "C", 1);
    ex2.setEdge("A", "E", 14);
    ex2.setEdge("A", "D", 20);
    ex2.setEdge("D", "C", 7);
    ex2.setEdge("C", "B", 17);
    ex2.setEdge("B", "E", 13);
    ex2.display();
    ex2.topologicalSortWithQueue();

    System.out.println();
    System.out.println("Example 3:");
    AdjGraph ex3 = new AdjGraph();
    String[] vertices3 = {"A", "B", "C", "D", "E", "F"};
    ex3.setVertices(vertices3);
    ex3.setEdge("A", "B", 10);
    ex3.setEdge("B", "C", 8);
    ex3.setEdge("B", "E", 8);
    ex3.setEdge("E", "D", 8);
    ex3.setEdge("D", "C", 8);
    ex3.setEdge("C", "F", 32);
    ex3.setEdge("D", "F", 40);
    ex3.display();
    ex3.topologicalSortWithQueue();


}
} // end of class AdjGraph