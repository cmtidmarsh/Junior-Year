// C343 Summer 2020
//
// a simple implementation for graphs with adjacency lists

// C343 / Summer 2020
// Lab - 14
// July 23, 2020 11:36
// Clare Tidmarsh, cmtidmar

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class adjGraph implements Graph {

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
    private int[][] NofE;

    public adjGraph() {
        init();
    }

    public adjGraph(boolean ifdigraph) {
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


    public void DFS(int v) {
        setVisited(v);
        LinkedList<Integer> neighbors = adjList.elementAt(v);
        for (int i = 0; i < neighbors.size(); i ++) {
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


    // Lab 14 TODO: Implement a method called floydNoWeights() that computes the length (in this case it's equivalent to the
    // number of edges in the path) of the shortest path for every pair of nodes in the graph, and displays the results in a
    // format that's easy to read.
    //Note: for this task, there are no "weights" for the edges (and the weights are not properly handled in the provided
    // starting source code!)
    //In the initialization step:
    //if there is an edge from u to v, set the number of edges between these two nodes to 1;
    //otherwise, set the counter to a very large number (e.g., Integer.MAX_VALUE).
    //Write a main() method in AdjGraph.java, where you need define three non-trivial graphs, and test your floydNoWeights()
    // method on each one of those graphs. In particular, your test graphs should have no less than 5 vertices, and no less
    // than 7 edges connecting those vertices.

    /**
     * NofE(u, v) an element
     *
     * @param u integer value
     * @param v integer value
     * @return a matrix of NofE with values at [u][v]
     */
    public static int[][] NofE(int u, int v) {
        int[][] NofE = new int[u][v];
        return NofE;
    }


    /**
     * First pseudocode from Lab 14 documentation at O(v^4) time complexity
     * @return returns an integer array
     */
        int[][] floydNoWeights () {

            int counter = 0;
//            if (NofE[u][v] == true){
//                NofE[u][v] = 1;
//                counter++;
//            }else{
//            counter = Integer.MAX_VALUE;

            int n = NofE.length;
            for (int m = 1; m < n - 1; m++) {
                for (int i = 0; i < n; i++) {
                    for (int j = i; j < n; j++) {
                        for (int k = 1; k < n; k++) {
                            // "relaxation" step (not for a single edge)
                            //  i.e. the triangle inequality
                            if (NofE[i][j] > NofE[i][k] + NofE[k][j]) {
                                NofE[i][j] = NofE[i][k] + NofE[k][j];
                            }
                        }
                    }
                }
            }
            return NofE;
        }
    /**
     * Second/"Better" pseudocode from Lab 14 documentation at O(v^3) time complexity
     * @return returns an integer array
     */
        int[][] floydNoWeights2 () {
            int u = 0, v = 0;
            int n = NofE.length;
            for (int i = 1; i < n; i++) {
                NofE[i][i] = 0;
            }

            for (int e = 0; e < NofE[u][v]; e++) {
                NofE[u][v] = 1;
            }
            for (int k = 1; k < n; k++) {
                for (int i = 1; i < n; i++) {
                    for (int j = 1; j < n; j++) {
                        if (NofE[i][j] > NofE[i][k] + NofE[k][j]) {
                            NofE[i][j] = NofE[i][k] + NofE[k][j];
                        }
                    }
                }
            }
            return NofE;

        }

    public static void main(String[] args) {
        adjGraph graph = new adjGraph();
        String[] vertices = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        graph.setVertices(vertices);
        graph.setEdge("1", "2", 1);
        graph.setEdge("2", "3", 2); // component one (two edges)

        graph.setEdge("4", "5", 3); // component two (1 edge)

        graph.setEdge("6", "7" , 4); // component three (1 edge)

        graph.setEdge("7", "8", 5);
        graph.setEdge("8", "9" , 6);
        graph.setEdge("9", "10" , 7); // component four (3 edges)
                                     // --------------------------
                                    //   Four components - 7 edges


        adjGraph graph2 = new adjGraph();
        String[] vertices2 = {"a", "b", "c", "d", "e"};
        graph2.setVertices(vertices2);
        graph2.setEdge("a", "b", 1);
        graph2.setEdge("b", "c", 2);
        graph2.setEdge("b", "d", 1);

        graph2.setEdge("c", "d", 3);
        graph2.setEdge("d", "e", 4);

        graph2.setEdge("e", "a", 5);
        graph2.setEdge("a", "e", 6); // 5 vertices, 7 edges


        adjGraph graph3 = new adjGraph();
        String[] vertices3 = {"a", "b", "c", "d", "e"};
        graph3.setVertices(vertices2);
        graph3.setEdge("a", "b", 1);

        graph3.setEdge("b", "c", 2);

        graph3.setEdge("c", "d", 1);
        graph3.setEdge("d", "e", 1);

        graph3.setEdge("e", "a", 3);
        graph3.setEdge("a", "a", 4);

        graph3.setEdge("c", "e", 5); // 11 vertices , 7 edges



        graph.floydNoWeights();
    }

} // end of class AdjGraph
