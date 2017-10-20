package graph.adjacent_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Graph
{
    static class Vertex{
        int data;
        boolean visited;
        public Vertex(){}
        public Vertex(int data){
            this.data = data;
            this.visited = false;
        }
        public Vertex(int data, boolean visited){
            this.data = data;
            this.visited = visited;
        }
    }

    static class Edge{
        public int source, destination, weight;
        public Edge (int src, int des){
            source = src;
            destination = des;
            weight = 0;
        }

        public Edge(){}
        public Edge(int src, int des, int wt){
            source = src;
            destination = des;
            weight = wt;
        }
        public String toString(){
            return source + " " + destination + " " + weight;
        }
    }

    private  Map<Integer, List<Edge>> adjacencyList;
    private Vertex[] vertexList;
    int vertexCount;
    
    public Graph(int vertexCount)
    {
        this.vertexCount = vertexCount;
        adjacencyList = new HashMap<Integer, List<Edge>>();
        vertexList = new Vertex[vertexCount + 1];
        for (int i = 1 ; i <= this.vertexCount; i++)
        {
            vertexList[i] = new Vertex(i);
            adjacencyList.put(i, new LinkedList<Edge>());
        }
    }

    public void addEdge(int source , int destination)
    {
        if (source > adjacencyList.size() || destination > adjacencyList.size())
        {
            System.out.println("The vertex entered in not present ");
            return;
        }
        List<Edge> slist = adjacencyList.get(source);
        slist.add(new Edge(source, destination, 0));
        List<Edge> dlist = adjacencyList.get(destination);
        dlist.add(new Edge(source, destination, 0));
    }

    public void addEdge(int source , int destination, int weigth)
    {
        if (source > adjacencyList.size() || destination > adjacencyList.size())
        {
            System.out.println("the vertex entered in not present ");
            return;
        }
        List<Edge> slist = adjacencyList.get(source);
        slist.add(new Edge(source, destination, weigth));
        List<Edge> dlist = adjacencyList.get(destination);
        dlist.add(new Edge(source, destination, weigth));
    }

    public void addEdgeDAG(int source , int destination)
    {
        if (source > adjacencyList.size() || destination > adjacencyList.size())
        {
            System.out.println("The vertex entered in not present ");
            return;
        }
        List<Edge> slist = adjacencyList.get(source);
        slist.add(new Edge(source, destination, 0));
    }

    public void addEdgeDAG(int source , int destination, int weigth)
    {
        if (source > adjacencyList.size() || destination > adjacencyList.size())
        {
            System.out.println("the vertex entered in not present ");
            return;
        }
        List<Edge> slist = adjacencyList.get(source);
        slist.add(new Edge(source, destination, weigth));
    }

    public List<Edge> getEdge(int source)
    {
        if (source > adjacencyList.size())
        {
            System.out.println("the vertex entered is not present");
            return null;
        }

        return adjacencyList.get(source);
    }

    //DFS

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
    }

    public int getAdjUnvisitedVertex(int ele){
        List<Edge> list = adjacencyList.get(ele);
        for(Edge edge : list){
            if(!this.vertexList[edge.destination].visited){
                return edge.destination;
            }
        }
        return -1;
    }

    public static void main(String...arg)
    {
        int source, destination;
        int numberOfEdges, numberOfVertices;
        int count = 0;
        Scanner scan = new Scanner(System.in);
        try
        {
            System.out.println("Enter the number of vertices and edges in graph: ");
            numberOfVertices = scan.nextInt();
            numberOfEdges = scan.nextInt();
            Graph graph = new Graph(numberOfVertices);
            System.out.println("Enter the edges in graph Format : <source index> <destination index>");
            while (count < numberOfEdges)
            {
                source = scan.nextInt();
                destination = scan.nextInt();
                graph.addEdgeDAG(source, destination);
                count++;
            }

            System.out.println ("The given Adjacency List for the graph \n");

            for (int i = 1 ; i <= numberOfVertices ; i++)
            {
                System.out.print(i+"->");
                List<Edge> edgeList = graph.getEdge(i);
                System.out.print(edgeList);
                System.out.println();
            }

            graph.dfs(1);
        }
        catch(InputMismatchException inputMismatch)
        {
            System.out.println("Error in Input Format. \nFormat : <source index> <destination index>");
        }
        scan.close();
    }
}