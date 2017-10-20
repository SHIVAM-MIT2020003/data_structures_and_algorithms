package graph.hackerrank.roads_and_libraries;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            int e = scanner.nextInt();
            int libCost = scanner.nextInt();
            int roadCost = scanner.nextInt();
            LinkedList<Integer>[] graph = new LinkedList[n];
            for(int i = 0; i < n; i++){
                graph[i] = new LinkedList<>();
            }
            for(int i = 0; i < e; i++){
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                graph[u].add(v);
                graph[v].add(u);
            }

            int res = bfs(graph, 0, libCost, roadCost);
            System.out.println(res);
        }
    }

    public static int bfs(LinkedList<Integer>[] graph, int s, int libCost, int roadCost){
        boolean[] isVisited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        isVisited[s] = true;
        int roadCount = 0;
        while (!queue.isEmpty()){
            int u = queue.remove();
            LinkedList<Integer> adj = graph[u];
            for(int v : adj){
                if(!isVisited[v]){
                    isVisited[v] = true;
                    queue.offer(v);
                    roadCount++;
                }
            }
        }
        if(libCost > roadCost){
            return libCost + roadCount * roadCost;
        }else{
            return graph.length * libCost;
        }
    }
}
