
// C343 Summer 2020
//
// a simple implementation for graphs with adjacency lists

// lab 15 starter file

// C343 / Summer 2020
// Lab - 15
// July 24, 2020 11:31
// Clare Tidmarsh, cmtidmar


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class AdjGraph<Vertex> implements Graph {
 private boolean known;

 private static final int V = 10 ;
 // is it a directed graph (true or false) :
 private boolean digraph;

 private int totalNodes;
 // all the nodes in the graph:
 private Vector<String> nodeList;

 private int totalEdges;
 // all the adjacency lists, one for each node in the graph:
 private Vector<LinkedList<Integer>> adjList;

 // all the weights of the edges, one for each node in the graph:
 private Vector<LinkedList<Integer>> adjWeight;

 // every visited node:
 private Vector<Boolean> visited;

 // list of nodes pre-visit:
 private Vector<Integer> nodeEnum;


 public AdjGraph() {
  init();
 }

 public AdjGraph(boolean known, boolean ifdigraph) {
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
 }

 // set vertices:
 public void setVertices(String[] nodes) {
  for (int i = 0; i < nodes.length; i++) {
   nodeList.add(nodes[i]);
   adjList.add(new LinkedList<Integer>());
   adjWeight.add(new LinkedList<Integer>());
   visited.add(false);
   totalNodes++;
  }
 }

 // add a vertex:
 public void addVertex(String label) {
  nodeList.add(label);
  visited.add(false);
  adjList.add(new LinkedList<Integer>());
  adjWeight.add(new LinkedList<Integer>());
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
   LinkedList<Integer> tmp2 = adjWeight.elementAt(v1);
   tmp2.add(weight);
   adjWeight.set(v1, tmp2);
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

 // Lab 15 TODO:
 //
 // write your methods here.
 //


 public void relax(int u, int v, int[] e) {
  //int[] previous = new int[dist];
  int[] dist = new int[V];
  int[] previous = new int[V];
  int weight = getWeight(v, u);
  if (dist[v] > dist[u] + e[weight]){
   dist[v] = dist[u] + e[weight];
   previous[v] = u;
  }
 }

 int decrease(int v, int u) {
  for (int i = 0; i < u; --i) { // from
   --v;
  }
  return v;
 }


 void dijkstra(Vertex s) {
   LinkedList<Vertex> path = new LinkedList<Vertex>();
   Vertex v, w;
   int[] dist = new int[V];
   int INFINITY = Integer.MAX_VALUE; // INFINITY in the pseudocode is not defined, so INFINITY is at MAX_VALUE
   for (int i = 0; i < V; i++) { // for each Vertex v
    v.dist = INFINITY;
    v.known = false; // set known vertex to false
   }
   s.dist = 0;
   while (!v.known) { //while ( there is an unknown distance vertex )
    v.dist = Integer.MIN_VALUE; // Vertex v = smallest unknown distance vertex;
    v.known = true; // set known vertex to true
    for (int i = 0; i < V; i++) { //for each Vertex w adjacent to v
     if (!w.known) {
      int cvw = relax(v, w, dist); // DistType cvw = cost of edge from v to w;
     if (v.dist + cvw < w.dist) {
 // Update w
       decrease(w.dist, v.dist + cvw); // decrease( w.dist to v.dist + cvw );
       w.path = v;
     }
    }
   }
  }
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


 public static void main(String argv[]) {
  AdjGraph g1 = new AdjGraph(known, true);
  String[] nodes1 = {"A", "B", "C", "D", "E"};
  int weight = 1;
  g1.setVertices(nodes1);
  g1.setEdge("A", "B", weight);
  g1.setEdge("B", "C", weight);
  g1.setEdge("C", "D", weight);
  g1.setEdge("A", "C", weight);

  //second example: g2
  AdjGraph g2 = new AdjGraph(known, true);
  String[] nodes2 = {"a", "b", "c", "d", "e", "f"};
  g2.setVertices(nodes2);
  g2.setEdge("a", "b", 9);
  g2.setEdge("a", "f", 5);
  g2.setEdge("a", "e", 3);
  g2.setEdge("b", "c", 5);
  g2.setEdge("b", "f", 4);
  g2.setEdge("c", "d", 2);
  g2.setEdge("c", "f", 8);
  g2.setEdge("d", "f", 7);
  g2.setEdge("d", "e", 1);
  g2.setEdge("e", "f", 5);


// Lab 15 TODO:

// write your new main() method here:

// provide 3 different examples, using the two different versions of Dijkstra's algorithm
//   with at least 10 nodes for each different graph

 AdjGraph graph = new AdjGraph();
 String[] vertices = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
 graph.setVertices(vertices);
 graph.setEdge("1", "2", 1);
 graph.setEdge("2", "3", 2); // component one (two edges)

 graph.setEdge("4", "5", 3); // component two (1 edge)

 graph.setEdge("6", "7", 4); // component three (1 edge)

 graph.setEdge("7", "8", 5);
 graph.setEdge("8", "9", 6);
 graph.setEdge("9", "10", 7); // component four (3 edges)
 // --------------------------
 //   Four components - 7 edges


 AdjGraph graph2 = new AdjGraph();
 String[] vertices2 = {"a", "b", "c", "d", "e"};
 graph2.setVertices(vertices2);
 graph2.setEdge("a", "b", 1);
 graph2.setEdge("b", "c", 2);
 graph2.setEdge("b", "d", 1);

 graph2.setEdge("c", "d", 3);
 graph2.setEdge("d", "e", 4);

 graph2.setEdge("e", "a", 5);
 graph2.setEdge("a", "e", 6); // 5 vertices, 7 edges


 AdjGraph graph3 = new AdjGraph();
 String[] vertices3 = {"a", "b", "c", "d", "e"};
 graph3.setVertices(vertices2);
 graph3.setEdge("a", "b", 1);

 graph3.setEdge("b", "c", 2);

 graph3.setEdge("c", "d", 1);
 graph3.setEdge("d", "e", 1);

 graph3.setEdge("e", "a", 3);
 graph3.setEdge("a", "a", 4);

 graph3.setEdge("c", "e", 5); // 11 vertices , 7 edges

}
}
