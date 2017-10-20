package graph.geeksforgeeks.dijkstras_algorithm;

import java.util.*;
import java.util.*;

class Node implements Comparable<Node>{
    public int id;
    public int distance;
    public Node(int id, int distance){
        this.id = id;
        this.distance = distance;
    }

    public int compareTo(Node node){
        return this.distance - node.distance;
    }

    public boolean equals(Object o){
        Node n = (Node)o;
        if(n.id == this.id && n.distance == this.distance)
            return true;
        else
            return false;
    }
}

public class Solution {
    public static void main(String[]a){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            int e = scanner.nextInt();
            int[][] graph = new int[n][n];

            for(int i = 0; i < e; i++){
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                int w = scanner.nextInt();

                if(graph[u][v] > 0){
                    if(w < graph[u][v]){
                        graph[u][v] = w;
                        graph[v][u] = w;
                    }
                }else{
                    graph[u][v] = w;
                    graph[v][u] = w;
                }

            }
            int s = scanner.nextInt() - 1;
            int[] distance = sortedPathInWeightedGraphDIJSKTRA(graph, s);
            for(int i = 0; i < distance.length; i++){
                if(i != s){
                    if(distance[i] == Integer.MAX_VALUE){
                        System.out.print(-1 + " ");
                    }else{
                        System.out.print(distance[i] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static int[] sortedPathInWeightedGraphDIJSKTRA(int[][] graph, int start){
        int[] distance = new int[graph.length];
        int[] path = new int[graph.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.offer(new Node(start, 0));
        Set<Integer> set = new HashSet<>();
        while(!pq.isEmpty()){
            Node pn = pq.poll();
            int node = pn.id;
            set.add(node);

            for(int j = 0; j < graph.length; j++){
                if(graph[node][j] != 0 && !set.contains(j)){
                    int newDistance = distance[node] + graph[node][j];
                    if(distance[j] == Integer.MAX_VALUE){
                        distance[j] = newDistance;
                        pq.offer(new Node(j, distance[j]));
                        path[j] = node;
                    }
                    if(distance[j] > newDistance){
                        pq.remove(new Node(j, distance[j]));
                        distance[j] = newDistance;
                        pq.offer(new Node(j, distance[j]));
                        path[j] = node;
                    }
                }
            }
        }
        return distance;
    }
}
