package graphImpl;

import java.util.*;

public class Graph {

    List<Node> vertices;
    GraphType graphType;
    int size = 0;

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }


    public Graph(GraphType graphType) {
        vertices = new ArrayList<Node>();
        this.graphType = graphType;
    }

    public  void addVertex(Node vertex) {
        this.vertices.add(vertex);
        size++;
    }

    public int numberOfVertices() {
        return size;
    }

    public void addEdge(Node source, Node destination) {

        source.neighbors.add(destination);

        if(graphType.equals(GraphType.UNDIRECTED)) {
            destination.neighbors.add(source);
        }
    }

    public static class Node{

        char data;
        List<Node> neighbors;

        public Node(char data) {
            this.data = data;
            neighbors = new ArrayList<Node>();
        }

    }

    public static void printGraph(Graph g) {
        for(Node vertex: g.vertices) {
            System.out.println("Vertex " + vertex.data);
            for(Node neighbor: vertex.neighbors) {
                System.out.println("\t Neighbor => " + neighbor.data);
            }
        }
    }


    public List<Node> getAdjacentVertices(Node node) {

        List<Node> list = new ArrayList<>();

        for(Node neighbor: node.neighbors) {
            System.out.println(("Neighbors => " + neighbor.data));
            list.add(neighbor);
        }
        return list;
    }

    public static boolean isConnected(Node source, Node destination) {

        return dfsrecur(source, destination);
    }

    public static boolean dfsrecur(Node source, Node destination) {

        if (source == destination) return false;
        HashSet<Node> visited = new HashSet<>();

        return dfsrecur(source, destination, visited);
    }

    public static boolean dfsrecur(Node source, Node destination, HashSet<Node> visited) {
        if(visited.contains(source)) return false;

        visited.add(source);

        if(source == destination) {
            return true;
        }

        for(Node child: source.neighbors) {
            if(dfsrecur(child, destination, visited))
                return true;
        }

        return false;
    }

    public boolean dfs(Node node) {
        HashSet<Node> visited = new HashSet<>();

        return dfs(node, visited);
    }

    public boolean dfs(Node node, HashSet<Node> visited) {
        if(visited.contains(node)) {
            return false;
        }

        visited.add(node);
        System.out.println(node.data + "-> ");

        List<Node> list = node.neighbors;
        for(Node neighbor: list) {
            dfs(neighbor, visited);
        }

        return false;
    }

    public void bfs(Node node) {

        Deque<Node> queue = new ArrayDeque<>();
        queue.push(node);

        HashSet<Node> visited = new HashSet<>();

        while(!queue.isEmpty()) {
            Node vertex = queue.removeFirst();

            if(visited.contains(vertex)) {
                continue;
            }

            System.out.println(vertex.data + " -> ");

            visited.add(vertex);

            List<Node> list = vertex.neighbors;
            for(Node neighbor: list) {
                if(!visited.contains(neighbor)) {
                    queue.addLast(neighbor);
                }
            }
        }
    }



    public static void main(String[] args) {
        Graph graph = new Graph(GraphType.UNDIRECTED);



        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);



        graph.addEdge(a, b);
        graph.addEdge(a, c);
        graph.addEdge(b, c);
        graph.addEdge(c, d);
        graph.addEdge(d, b);

        printGraph(graph);

        graph.getAdjacentVertices(a);

        System.out.print(isConnected(a, d));

        graph.dfs(c);

        System.out.println("Number of vertices " + graph.numberOfVertices());

        graph.bfs(c);



    }


}
