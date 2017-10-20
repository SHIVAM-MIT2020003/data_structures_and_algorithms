package graph.geeksforgeeks.sortest_path_from_s_to_all_BFS;

import java.nio.channels.ScatteringByteChannel;
import java.util.*;

public class Solution {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        LinkedList<Integer>[] graph = new LinkedList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new LinkedList<>();
        }
        for(int i = 0; i < e; i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u].add(v);
        }
        int s = scanner.nextInt();
        int[] distance = findSortestPath(graph, s);
        for(int i = 0; i < distance.length; i++){
            System.out.println(s + " -> " + i + " cost " + distance[i]);
        }
    }

    public static int[] findSortestPath(LinkedList<Integer>[] graph, int s){
        int[] distance = new int[graph.length];
        int[] path = new int[graph.length];
        Arrays.fill(distance, -1);
        Arrays.fill(path, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        distance[s] = 0;
        while (!queue.isEmpty()){
            int u = queue.remove();
            LinkedList<Integer> adj = graph[u];
            for(int node : adj){
                if(distance[node] == -1){
                    distance[node] = distance[u] + 1;
                    path[node] = u;
                    queue.offer(node);
                }
            }
        }
        return distance;
    }
}
