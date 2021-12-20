
// C343 Summer 2020
//
// a simple implementation for graphs with adjacency lists


// C343 / Summer 2020
// Lab - 13
// July 22, 2020 11:00
// Clare Tidmarsh, cmtidmar

/**
 * @note I think I got the components to print out correctly, but had trouble with also getting the size of each
 * without adjusting the DFS function to count how many nodes are in a component.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class AdjGraph implements Graph {
    // is it a directed graph (true or false) :
    private boolean digraph;

    private int totalNodes;
    // all the nodes in the graph:
    private Vector<String> nodeList;

    private int totalEdges;
    // all the adjacency lists, one for each node in the graph:
    private Vector<LinkedList<Integer>>  adjList;

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
    }

    // set vertices:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i ++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes ++;
        }
    }

    // add a vertex:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
        totalNodes ++;
    }

    public int getNode(String node) {
        for (int i = 0; i < nodeList.size(); i ++) {
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
            adjList.set(v1,  tmp);
            totalEdges ++;
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
        for (int i = 0; i < nodeList.size(); i ++)
            visited.set(i, false);
    }

    public void walk(String method) {
        clearWalk();
        // traverse the graph:
        for (int i = 0; i < nodeList.size(); i ++) {
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

    // Lab 13 TODO:
    //
    // write your componentsAndSizes() method here.
    //

    public void componentsAndSizes() {
        int count = 0; // counts the component
        int nodesInComp = 0; // counts the number of nodes in the component
        int components = 0; //counts the total number of components
        for (int i = 0; i < nodeList.size(); i++) { // for each node in the list of nodes
            if (ifVisited(i) == false) { // if a node in a component is not visited
                DFS(i); // then visit
                components++; // and count the component
                System.out.println("Component " + count++ + " contains " + nodesInComp);
            }
        }
        System.out.println("Total components: " + components);

   }
    public void DFS(int v) {
        setVisited(v);
        LinkedList<Integer> neighbors = adjList.elementAt(v);
        for (int i = 0; i < neighbors.size(); i++) {
            int v1 = neighbors.get(i);
            if (ifVisited(v1) == false) {
                DFS(v1);
            }
        }
    }

    public void BFS(int s) {
        ArrayList<Integer> toVisit = new ArrayList<Integer>();
        toVisit.add(s);
        while (toVisit.size() > 0) {
            int v = toVisit.remove(0);   // first-in, first-visit
            setVisited(v);
            LinkedList<Integer> neighbors = adjList.elementAt(v);
            for (int i = 0; i < neighbors.size(); i ++) {
                int v1 = neighbors.get(i);
                if ( (ifVisited(v1) == false) && (toVisit.contains(v1) == false) ) {
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
        for (int i = 0; i < nodeEnum.size(); i ++) {
            System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
        }
        System.out.println();
    }

    // Lab 13 TODO:

    // write a main() method here:

    // 1) instantiate a new graph,
    // 2) assign 2 vertices and edges to the graph,
    // 3) then display 2 the graph's content (use display() )
    // 4) finally call your componentsAndSizes() method to provide
    //    output results as from Lab 13 instructions

    // provide 3 different examples,
    //   with at least 10 nodes for each different graph

    public static void main(String[] args) {

        System.out.println("A, B, C, D, and E graph:");
        // 1) instantiate a new graph,
        AdjGraph graph = new AdjGraph();

        // 2) assign 2 vertices and edges to the graph,
        String[] nodes = {"A", "B", "C", "D", "E"};
        graph.setVertices(nodes);
        graph.setEdge("A", "B", 2); // public void setEdge(String v1, String v2, int weight);
        graph.setEdge("B", "C", 8); // public void setEdge(String v1, String v2, int weight);

        // 3) then display 2 the graph's content (use display() )
        graph.display();
        // 4) finally call your componentsAndSizes() method to provide
        graph.componentsAndSizes();

        System.out.println();
        System.out.println("Example 1:");
        //  5) provide 3 different examples, with at least 10 nodes for each different graph
        AdjGraph example1 = new AdjGraph();
        String[] example1nodes = {"F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};
        example1.setVertices(example1nodes);
        // First Component
        example1.setEdge("F", "G", 1); // public void setEdge(String v1, String v2, int weight);
        example1.setEdge("G", "H", 2);

        // Second Component
        example1.setEdge("I", "J", 3);

        // Third Component
        example1.setEdge("K", "L", 4);

        // Forth Component
        example1.setEdge("N", "O", 5);

        example1.display();
        example1.componentsAndSizes();

        System.out.println();
        System.out.println("Example 2:");
        //  5) provide 3 different examples, with at least 10 nodes for each different graph
        AdjGraph example2 = new AdjGraph();
        String[] example2nodes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        example2.setVertices(example2nodes);
        // First Component: EVENS
        example2.setEdge("2", "4", 1);
        example2.setEdge("4", "6", 2);
        example2.setEdge("6", "8", 3);
        example2.setEdge("8", "10", 4);

        // Second Component: ODDS
        example2.setEdge("1", "3", 5);
        example2.setEdge("3", "5", 6);
        example2.setEdge("5", "7", 7);
        example2.setEdge("7", "9", 8);

        example2.display();
        example2.componentsAndSizes();

        System.out.println();
        System.out.println("Example 3:");
        AdjGraph example3 = new AdjGraph();
        String[] example3nodes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        example3.setVertices(example3nodes);
        // First Component
        example3.setEdge("1", "2", 1);
        // Second Component
        example3.setEdge("3", "4", 2);
        // Third Component
        example3.setEdge("5", "6", 3);
        // Forth Component
        example3.setEdge("7", "8", 4);
        // Fifth Component
        example3.setEdge("9", "10", 5);

        example3.display();
        example3.componentsAndSizes();







    }

} // end of class AdjGraph