package graph.adjacent_matrix;
import java.util.*;

class Vertex{
    int data;
    boolean visited;
    public Vertex(){}
    public Vertex(int data){
        this.data = data;
        this.visited = false;
    }
}

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int weight;

    public Edge(){}
    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int compareTo(Edge edge){
        return weight - edge.weight;
    }

    public boolean equals(Object o){
        Edge e = (Edge)o;
        if(e == null)
            return false;

        return from == e.from && to == e.to && weight == e.weight;
    }

    public int hashCode(){
        return from + to + weight;
    }

    public String toString(){
        return from + " " + to + " " + weight;
    }
}

class DisjointSet{
    private Map<Integer, Node> map = new HashMap<>();

    class Node{
        int data;
        int rank;
        Node parent;
    }

    public void makeSet(int data){
        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        map.put(data, node);
    }

    public int findSet(int data){
        return findSet(map.get(data)).data;
    }

    private Node findSet(Node node){
        Node parent = node.parent;
        if(parent == node){
            return parent;
        }

        node.parent = findSet(node.parent);
        return node.parent;
    }

    public void union(int data1, int data2){
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        if(parent1.data == parent2.data){
            return;
        }

        if(parent1.rank >= parent2.rank){
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        }else{
            parent1.parent = parent2;
        }
    }
}

class PriorityNode implements Comparable<PriorityNode>{
    int id;
    int distance;

    public PriorityNode(){}
    public PriorityNode(int id, int distance){
        this.id = id;
        this.distance = distance;
    }

    public int compareTo(PriorityNode pq){
        if(pq != null)
            return distance - pq.distance;
        throw new IllegalArgumentException("unexpected argument");
    }

    public boolean equals(Object o){
        PriorityNode t = (PriorityNode)o;
        if(t.id == id){
            return true;
        }else{
            return false;
        }
    }

    public int hashCode(){
        return id + distance;
    }
}

public class Graph {
    public int vertexCount = 0;
    public int[][] Adj;
    public Vertex[] vertexList;

    public Graph(){}

    public Graph(int vertex){
        this.vertexCount = vertex;
        Adj = new int[this.vertexCount][this.vertexCount];
        vertexList= new Vertex[this.vertexCount];
        for(int i = 0; i < this.vertexCount; i++){
            vertexList[i] = new Vertex(i);
        }
    }

    public int[] calculateInDegree(Graph g){
        int[] inDegree = new int[this.vertexCount];
        for(int i = 0; i < Adj.length; i++){
            for(int j = 0; j < Adj[0].length; j++){
                if(Adj[i][j] == 1){
                    inDegree[j]++;
                }
            }
        }
        return inDegree;
    }

    public void reset(Vertex[] vertexList){
        for(int i = 0; i < vertexList.length; i++){
            vertexList[i].visited = false;
        }
    }

    public int getAdjUnvisitedVertex(int ele){
        for(int i = 0; i < this.vertexCount; i++){
            if(this.Adj[ele][i] == 1 && !this.vertexList[i].visited){
                return i;
            }
        }
        return -1;
    }

    //only for bidirectional search.
    public int getAdjUnvisitedVertexBIDIRECTIONALSEARCH(int ele){
        for(int i = 0; i < this.vertexCount; i++){
            if(this.Adj[ele][i] == 1 && !this.vertexList[i].visited){
                vertexList[i].visited = true;
                return i;
            }
        }
        return -1;
    }

    public void addEdgeUndirectedGraph(int u, int v){
        Adj[u][v] = 1;
        Adj[v][u] = 1;
    }

    public void addEdgeInDirectedGraph(int u, int v){
        Adj[u][v] = 1;
    }
    public void addEdgeInWeightedDirectedGraph(int u, int v, int weight){
        Adj[u][v] = weight;
    }

    public void addEdgeInWeightedUndirectedGraph(int u, int v, int weight){
        Adj[u][v] = weight;
        Adj[v][u] = weight;
    }

    public void dfs(int start){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);
        vertexList[start].visited = true;
        System.out.println(start);
        while(!stack.isEmpty()){
            int ver = getAdjUnvisitedVertex(stack.peek());
            if(ver == -1){
                stack.pop();

            }else{
                vertexList[ver].visited = true;
                System.out.println(ver);
                stack.push(ver);
            }
        }
        reset(vertexList);
    }

    public int countNumberOfSimplePath(Graph g, int s, int d){
        int count = 0;
        if(s == d){
            count++;
            return count;
        }

        for(int i = 0; i < g.vertexCount; i++){
            if(g.Adj[s][i] != 0 && modifiedDFS(g, i, d)){
                count++;
            }
        }
        return count;
    }


    public boolean hasSimplePath(Graph g, int s, int d){
        if(s == d)
            return true;

        vertexList[s].visited = true;
        for(int i = 0; i < g.vertexCount; i++){
            if(g.Adj[s][i] != 0 && !vertexList[i].visited && modifiedDFS(g, i, d)){
                return true;
            }
        }
        reset(vertexList);
        return false;
    }


    public boolean modifiedDFS(Graph graph, int s, int d){
        reset(vertexList);
        if(s == d){
            return true;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s);
        vertexList[s].visited = true;
        while(!stack.isEmpty()){
            int ver = getAdjUnvisitedVertex(stack.peek());
            if(ver == -1){
                stack.pop();
            }else{
                vertexList[ver].visited = true;
                if(ver == d)
                    return true;
                stack.push(ver);
            }
        }

        return false;
    }

    public void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        System.out.println(start);
        vertexList[start].visited = true;
        int v2;
        while(!queue.isEmpty()){
            int v = queue.remove();
            while((v2 = getAdjUnvisitedVertex(v)) != -1){
                queue.add(v2);
                System.out.println(v2);
                vertexList[v2].visited = true;
            }
        }
        reset(vertexList);
    }

    public int[] topologicalSort(Graph g){
        int[] topologicalOrder = new int[g.vertexCount];
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = calculateInDegree(g);
        for(int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int v, w;
        int counter = 0;
        while(!queue.isEmpty()){
            v = queue.remove();
            topologicalOrder[v] = ++counter;
            for(int j = 0; j < g.vertexCount; j++){
                if((g.Adj[v][j] == 1) && (--inDegree[j] == 0)){
                    queue.add(j);
                }
            }
        }
        return topologicalOrder;
    }

    public int[] unweightedSortestPath(Graph graph, int start){
        if(graph == null){
            return null;
        }
        int[] distance = new int[graph.vertexCount];
        int[] path = new int[graph.vertexCount];
        for(int i = 0; i < graph.vertexCount; i++){
            distance[i] = -1;
        }
        distance[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int v;
        while(!queue.isEmpty()){
            v = queue.remove();
            for(int j = 0; j < graph.vertexCount;j++){
                if(graph.Adj[v][j] == 1 && distance[j] == -1){
                    distance[j] = distance[v] + 1;
                    queue.add(j);
                }
            }
        }
        return distance;
    }

    public int[] sortedPathInWeightedGraphDIJSKTRA(Graph g, int start){
        int[] distance = new int[g.vertexCount];
        int[] path = new int[g.vertexCount];
        PriorityQueue<PriorityNode> pq = new PriorityQueue<>(); //(E + V^2) -> (E*logV) using Binary Heap
        Arrays.fill(distance, -1);
        distance[start] = 0;
        pq.offer(new PriorityNode(start, 0));
        while(!pq.isEmpty()){
            PriorityNode pn = pq.poll();
            int node = pn.id;

            for(int j = 0; j < g.vertexCount; j++){
                if(g.Adj[node][j] != 0){
                    int newDistance = distance[node] + Adj[node][j];
                    if(distance[j] == -1){
                        distance[j] = newDistance;
                        pq.offer(new PriorityNode(j, distance[j]));//insert in priority queue.
                        path[j] = node;
                    }
                    if(distance[j] > newDistance){
                        pq.remove(new PriorityNode(j, distance[j]));
                        distance[j] = newDistance;
                        pq.offer(new PriorityNode(j, distance[j])); //update priority queue.
                        path[j] = node;
                    }
                }
            }
        }
        return distance;
    }

    public int[] sortedPathInWeightedGraphBELLMANFORD(Graph g, int start) {
        int[] distance = new int[g.vertexCount];
        int[] path = new int[g.vertexCount];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for (int i = 0; i < g.vertexCount - 1; i++) {
            outer:
            for (int r = 0; r < g.vertexCount; r++) {
                for (int c = 0; c < g.vertexCount; c++) {
                    if(distance[r] == Integer.MAX_VALUE)
                        continue outer;
                    if (g.Adj[r][c] != 0) {
                        if(distance[c] > distance[r] + g.Adj[r][c]){
                            distance[c] = distance[r] + g.Adj[r][c];
                            path[c] = r;
                        }
                    }
                }
            }
        }
        return distance;
    }


    public int[] minSpanningTreePRIMS(Graph g, int start){ //try to use kruskal's algorithm in place of prims
        int[] distance = new int[g.vertexCount];
        int[] path = new int[g.vertexCount];
        PriorityQueue<PriorityNode> pq = new PriorityQueue<>();
        Arrays.fill(distance, -1);
        distance[start] = 0;
        pq.offer(new PriorityNode(start, 0));
        while(!pq.isEmpty()){
            PriorityNode pn = pq.poll();
            int node = pn.id;
            printArray(distance);
            for(int j = 0; j < g.vertexCount; j++){
                if(g.Adj[node][j] != 0){
                    if(distance[j] == -1){
                        distance[j] = Adj[node][j];
                        pq.offer(new PriorityNode(j, distance[j]));
                        path[j] = node;
                    }
                    if(pq.contains(new PriorityNode(j , distance[j])) && distance[j] > g.Adj[node][j]){
                        pq.remove(new PriorityNode(j, distance[j]));
                        distance[j] = Adj[node][j];
                        pq.offer(new PriorityNode(j, distance[j]));
                        path[j] = node;
                    }
                }
            }
        }
        return distance;
    }

    public int minSpanningTreeKRUSKAL(){
        DisjointSet disjointSet = new DisjointSet();
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();

        for(int i = 1; i <= nodes; i++){
            disjointSet.makeSet(i);
        }

        List<Edge> list = new ArrayList<>();
        for(int i = 0; i < edges; i++){
            Edge edge = new Edge();
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int wt = scanner.nextInt();
            edge.from = u;
            edge.to = v;
            edge.weight = wt;
            list.add(edge);
        }

        Collections.sort(list);

        int cost = 0;
        for(int i = 0; i < list.size(); i++){
            Edge edge = list.get(i);
            int parent1 = disjointSet.findSet(edge.from);
            int parent2 = disjointSet.findSet(edge.to);
            if(parent1 != parent2){
                cost += edge.weight;
                disjointSet.union(edge.from, edge.to);
            }
        }
        return cost;
    }

    public int[][] allPairShortestPath(Graph g){
        int[][] paths = new int[g.vertexCount][g.vertexCount];
        for(int i = 0; i < g.vertexCount; i++){
            paths[i] = g.sortedPathInWeightedGraphDIJSKTRA(g, i);
        }
        return paths;
    }

    public int[][] allPairShortestPathFLOYEDWARSHALL(Graph g){
        if(g == null){
            return null;
        }

        int[][] paths = new int[g.vertexCount][g.vertexCount];
        for(int i = 0; i < g.vertexCount; i++){
            for(int j = 0; j < g.vertexCount; j++){
                if(g.Adj[i][j] != 0)
                    paths[i][j] = g.Adj[i][j];
                else
                    paths[i][j] = 9999;
            }
        }
        for(int i = 0; i < g.vertexCount; i++){ //source
            for(int j = 0; j <g.vertexCount; j++){ //destination
                for(int k = 0; k < g.vertexCount; k++){//intermediate node
                    if(paths[i][j] > paths[i][k] + paths[k][j]){
                        paths[i][j] = paths[i][k] + paths[k][j];
                    }
                }
            }
        }
        return paths;
    }
/*
    public boolean bidirectionalSearch(Graph g, int source, int destination){
        if(source == destination)
            return true;

        reset(g.vertexList);

        Queue<Integer> sourceQueue = new LinkedList<>();
        Queue<Integer> destinationQueue = new LinkedList<>();

        sourceQueue.add(source);
        sourceQueue.add(null);

        destinationQueue.add(destination);
        destinationQueue.add(null);

        g.vertexList[source].visited = true;
        g.vertexList[destination].visited = true;

        boolean isFromSource = true;
        while(!sourceQueue.isEmpty() && !destinationQueue.isEmpty()){
            if(isFromSource){
                isFromSource = false;
                while(!sourceQueue.isEmpty()){
                    Integer src = sourceQueue.remove();
                    if(src == null) {
                        if (!sourceQueue.isEmpty()) {
                            sourceQueue.add(null);
                        }else{
                            return false;
                        }
                        break;
                    }
                    for(int i = 0; i < g.vertexCount; i++){
                        if(vertexList[i].visited){
                            return true;
                        }

                        if(g.Adj[src][i] != 0){
                            vertexList[i].visited = true;
                            sourceQueue.add(i);
                        }
                    }
                }
            }else{
                isFromSource = true;
                while(!destinationQueue.isEmpty()){
                    Integer dst = destinationQueue.remove();
                    if(dst == null){
                        if(!destinationQueue.isEmpty()){
                            destinationQueue.add(null);
                        }else{
                            return false;
                        }
                        break;
                    }
                    int v1;
                    for(int i = 0; i < g.vertexCount; i++){
                        if(vertexList[i].visited){
                            return true;
                        }

                        if(g.Adj[dst][i] != 0){
                            vertexList[i].visited = true;
                            destinationQueue.add(i);
                        }
                    }
                }

            }
        }
        return false;
    }
*/


    public boolean bidirectionalSearch(int a, int b) {
        // BFS on both nodes at the same time
        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();
        Set<Integer> visitedA = new HashSet<Integer>();
        Set<Integer> visitedB = new HashSet<Integer>();

        visitedA.add(a);
        visitedB.add(b);
        queueA.add(a);
        queueB.add(b);

        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            if (pathExistsBidirectionalHelper(queueA, visitedA, visitedB)) {
                return true;
            }
            if (pathExistsBidirectionalHelper(queueB, visitedB, visitedA)) {
                return true;
            }
        }

        return false;
    }

    private boolean pathExistsBidirectionalHelper(Queue<Integer> queue, Set<Integer> visitedFromThisSide, Set<Integer> visitedFromThatSide) {
        if (!queue.isEmpty()) {
            int next = queue.remove();
            for (int i = 0; i < vertexCount; i++) {
                if (visitedFromThatSide.contains(Adj[next][i])) {
                    return true;
                } else if (visitedFromThisSide.add(Adj[next][i])) {
                    queue.add(Adj[next][i]);
                }
            }
        }
        return false;
    }
    //Helper methods.
    public void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public void addAllEdgesInList(List<Edge> list, Graph g){
        Set<String> set = new HashSet<>();
        for(int i = 0; i < g.Adj.length; i++){
            for(int j = 0; j < g.Adj[0].length; j++){
                String key = i + ":" + j;
                Edge e = new Edge(i, j, g.Adj[i][j]);
                if(g.Adj[i][j] != 0 && !set.contains(key)){
                    list.add(e);
                    set.add(i + ":" + j); set.add(j + ":" + i);
                }
            }
        }
    }

    public static int sumArrayElements(int[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        return sum;
    }

    public static void display2D(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.printf("%5d",mat[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdgeInDirectedGraph(0,3);
        g.addEdgeInDirectedGraph(0,1);
        g.addEdgeInDirectedGraph(1,2);
        g.addEdgeInDirectedGraph(2,3);
        //System.out.println(g.countNumberOfSimplePath(g, 1,0));
        //int[][] allPairSortestPaths = g.allPairShortestPathFLOYEDWARSHALL(g);
        // display2D(allPairSortestPaths);
        System.out.println(g.bidirectionalSearch(3,0));
    }
}
