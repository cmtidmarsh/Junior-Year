// C343 Summer 2020
//
// a simple implementation for graphs with adjacency lists

// --------------------------------------------------
// lab 15 solution - Dijkstra (version 1) implemented
// --------------------------------------------------

// C343/Summer 2020
// Lab - 16
// July 29, 2020 14:44
// Clare Tidmarsh, cmtidmar

import java.util.ArrayList;
import java.util.Arrays;
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

    // all the weights of the edges, one for each node in the graph:
    private Vector<LinkedList<Integer>> adjWeight;

    // every visited node:
    private Vector<Boolean> visited;

    // list of nodes pre-visit:
    private Vector<Integer> nodeEnum;

    // ---------------------------------------------------
    // lab 15 solution - Dijkstra (version 1) implemented:
    // d[] is the array of to-be-distances:
    private int[] d;
    // ---------------------------------------------------


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
        adjWeight = new Vector<LinkedList<Integer>>();
        visited = new Vector<Boolean>();
        nodeEnum = new Vector<Integer>();
        totalNodes = totalEdges = 0;
        digraph = false;
        // ---------------------------------------------------
        // lab 15 solution - Dijkstra (version 1) implemented:
        d = new int[totalNodes];
        // ---------------------------------------------------
    }

    // set vertices:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i ++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            adjWeight.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes ++;
        }
    }

    // add a vertex:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
        adjWeight.add(new LinkedList<Integer>());
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
            LinkedList<Integer> tmp2 = adjWeight.elementAt(v1);
            tmp2.add(weight);
            adjWeight.set(v1,  tmp2);
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


    // new for Lab 15:
    public LinkedList<Integer> getNeighbors(int v) {
        return adjList.get(v);
    }

    public int getWeight(int v, int u) {
        LinkedList<Integer> tmp = getNeighbors(v);
        LinkedList<Integer> weight = adjWeight.get(v);
        if (tmp.contains(u)) {
            return weight.get(tmp.indexOf(u));
        } else {
            return Integer.MAX_VALUE;
        }
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

    // ---------------------------------------------------
    // lab 15 solution - Dijkstra (version 1) implemented:
    // ---------------------------------------------------

    // ---------------------------------------------------
    // the edge relaxation operation, as seen at Lecture 15, operating on the d[] array:
    // ---------------------------------------------------
    private void relax(int u, int v, int w) {
        if ( d[v] > ( d[u] + w ) ) {
            d[v] = d[u] + w;
            // we don't need parent/predecessor nodes for Dijkstra's algorithm,
            //  but if necessary it would be set here:
            // predecessor[v] = u;
        }
    } // end of relax()


    // ---------------------------------------------------
    // the minVertex() method:
    //   find the next closest vertex to the set of visited vertices
    //   (uncomment println() statements for lots of debugging printout)
    // ---------------------------------------------------
    private int minVertex() {
        int v = 0;
        // initialize v to one (any!) *unvisited* vertex:
        for (int i = 0; i < totalNodes; i++) {
            if (ifVisited(i) == false) {
                v = i;
                break;
            }
        }
        // now look for the *closest* unvisited vertex:
        for (int i = 0; i < totalNodes; i++) {
            if ( (ifVisited(i) == false) && (d[i] < d[v]) ) {
                v = i;
            }
        }
        // return the *closest* unvisited vertex:
        return v;
    } // end of minVertex()


    // ---------------------------------------------------
    // Dijkstra's shortest path algorithm, implemented as from textbook page 391 :
    // (i.e. the dijkstra1() function for Lab 15)
    // ---------------------------------------------------
    public void dijkstra1(String sNode) {
        System.out.println ("");
        System.out.println("Dijkstra's shortest path algorithm, starting from node " + sNode);

        d = new int[totalNodes];
        int s = getNode(sNode);

        // initialize the d array:
        for (int i = 0; i < totalNodes; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[s] = 0;

        // print out the d array:
        System.out.println("the initial d[] array is : ");
        for (int i = 0; i < totalNodes; i++) {  System.out.print(d[i] + " " ); } System.out.println ("");

        // make sure that all vertices are unmarked:
        clearWalk();

        // starting Dijkstra's main loop:
        for (int i = 0; i < totalNodes; i++) {

            // find the closest vertex to all visited nodes:
            //   Note: the O() of minVertex impacts the O() of the entire Dijkstra's algorithm:
            int v = minVertex();

            setVisited(v);
            if (d[v] == Integer.MAX_VALUE) {
                System.out.println("unreachable vertex found in Dijkstra's algorithm!");
                return;
            }
            // now *relax* all neighbors of the node v:
            for (int neighbor : adjList.elementAt(v) ) {
                relax(v, neighbor, getWeight(v, neighbor));
            }

            System.out.println("after step " + i + " the d[] array is : ");
            for (int j = 0; j < totalNodes; j++) {  System.out.print(d[j] + " " ); } System.out.println ("");

        } // end of for() - Dijkstra's main loop

    } // end of dijkstra1()
    // ---------------------------------------------------

    public void primMST() {

        ArrayList<Vector<String>> S = new ArrayList<>(); // S: set of vertices NOT yet on the MST
        S.add(nodeList); // set S to include all the nodes
        //System.out.println("Testing nodes in S: " + S); //testing, outcome should be the nodes in the graph, YES
        int cost = 0;
        int[] dist = new int[nodeList.size()]; // total nodes = the length of the graph
        //System.out.println("Testing dist: "+ Arrays.toString(dist)); // testing dist array outcome should have 5 elements, YES
        dist[0] = 0; //  set dist[0] to 0, Prim's algorithm can start from any node; here 0 is used as the source
        // System.out.println("Testing dist[0]: " + dist[0]); // testing, outcome should be 0, YES
        for (int v = 1; v < dist.length; v++) {
            int INFINITY = Integer.MAX_VALUE;
            dist[v] = INFINITY; // set dist[v] to infinity for all other nodes v (v != 0)
            cost = 0;
        }
        System.out.println("Testing new dist element values: " + Arrays.toString(dist)); // testing dist values, outcome: dist[0] should be 0, and others should hold INFINITY, Yes

        if (!S.isEmpty()) { //if S is not empty, Repeat until S becomes empty:
            int minimum = dist[0];
            for (int u = 0; u < S.size(); u++) { // for each u in S, pseudocode: find vertex u with the smallest dist[u] among all unsettled vertices (S).
                if (dist[u] < minimum || dist[u] == minimum) { // if the element at dist[u] is less than the set minimum or if the dist[u] is the minimum
                    minimum = dist[u]; // update minimum,
                    System.out.println("Testing minimum distance: " + minimum); // testing the minimum, outcome should be the minimum in the array
                    System.out.println(S.get(u));
                    S.remove(u); // remove u from S
                    System.out.println("Testing new array: " + S); // testing the new array, outcome: should not contain the previous minimum value
                    cost += minimum; // and update the cost, cost <- cost + dist[u]/minimum
                    LinkedList neighbors = getNeighbors(u); // get the neighbors of u
                    for (int v = 0; v < dist.length; v++) { // for each element in the dist array,
                        for (int p = u; p < neighbors.size(); p++) { // and for every neighbor of u
                            dist[v] = (Integer) neighbors.get(p);
                        } // update dist[v] for every neighbor of u
                        // relaxation operation:
                        //int weight = getWeight(u, v);
                        if (getWeight(u, v) < dist[v]) { // if weight(u, v) < dist[v]
                            dist[v] = getWeight(u, v); // dist[v] = weight(u, v)
                        }
                    }

                }


            }

        }
        else { // if S.isEmpty()
            System.out.println("S is empty.");

        }
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


    // --------------------------------------------------------------
    // lab 15 solution - testing Dijkstra with three separate graphs:
    // --------------------------------------------------------------

    public static void main(String argv[]) {

        // first example: g1
        AdjGraph g1 = new AdjGraph(true);
        String[] nodes1 = {"A", "B", "C", "D", "E"};
        g1.setVertices(nodes1);
        g1.setEdge("A", "B", 10);
        g1.setEdge("A", "C", 3);
        g1.setEdge("A", "D", 20);
        g1.setEdge("B", "D", 5);
        g1.setEdge("C", "B", 2);
        g1.setEdge("C", "E", 15);
        g1.setEdge("D", "E", 11);
        System.out.println("-------------------- ");
        System.out.println("first graph example: ");
        g1.display();
        g1.walk("DFS");
        g1.walk("BFS");
        g1.dijkstra1("A");
        System.out.println("--------------------------- ");
        System.out.println("first graph work completed. ");
        System.out.println("--------------------------- ");
        System.out.println("");
        g1.primMST();


        // second example: g2 is the graph from
        //    https://commons.wikimedia.org/wiki/File:Dijkstra_Animation.gif
        AdjGraph g2 = new AdjGraph(false);
        String[] nodes2 = {"a", "b", "c", "d", "e", "f"};
        g2.setVertices(nodes2);
        g2.setEdge("a", "b", 7);
        g2.setEdge("a", "c", 9);
        g2.setEdge("a", "f", 14);
        g2.setEdge("b", "c", 10);
        g2.setEdge("b", "d", 15);
        g2.setEdge("c", "d", 11);
        g2.setEdge("c", "f", 2);
        g2.setEdge("d", "e", 6);
        g2.setEdge("e", "f", 9);
        System.out.println("--------------------- ");
        System.out.println("second graph example: ");
        g2.display();
        g2.walk("DFS");
        g2.walk("BFS");
        g2.dijkstra1("a");
        System.out.println("---------------------------- ");
        System.out.println("second graph work completed. ");
        System.out.println("---------------------------- ");
        System.out.println("");
        g2.primMST();


        // third example: g3 is the graph from
        //    https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec16.pdf
        AdjGraph g3 = new AdjGraph(true);
        String[] nodes3 = {"A", "B", "C", "D", "E"};
        g3.setVertices(nodes3);
        g3.setEdge("A", "B", 10);
        g3.setEdge("A", "C", 3);
        g3.setEdge("B", "C", 1);
        g3.setEdge("B", "D", 2);
        g3.setEdge("C", "B", 4);
        g3.setEdge("C", "D", 9);
        g3.setEdge("C", "E", 2);
        g3.setEdge("D", "E", 7);
        g3.setEdge("E", "D", 9);
        System.out.println("--------------------- ");
        System.out.println("third graph example: ");
        g3.display();
        g3.walk("DFS");
        g3.walk("BFS");
        g3.dijkstra1("A");
        System.out.println("--------------------------- ");
        System.out.println("third graph work completed. ");
        System.out.println("--------------------------- ");
        System.out.println("");
        g3.primMST();

    } // end of main()



} // end of class AdjGraph

