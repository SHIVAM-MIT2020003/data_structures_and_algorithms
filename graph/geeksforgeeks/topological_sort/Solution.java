package graph.geeksforgeeks.topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int nodes = kb.nextInt();
        int edges = kb.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[nodes];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges; i++){
            int u = kb.nextInt();
            int v = kb.nextInt();
            graph[u].add(v);
        }

        int[] ans = topologicalSort(graph, graph.length);
        for(int i = 0; i < ans.length; i++){
            System.out.println(i + " -> " + ans[i]);
        }

    }

    public static int[] topologicalSort(ArrayList<Integer> graph[], int N){
        int[] indegree = findInDegree(graph);
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int counter = 0;
        int[] ans = new int[graph.length];
        while (!queue.isEmpty()){
            int node = queue.remove();
            ans[node] = ++counter;
            ArrayList<Integer> adj = graph[node];
            for(int n : adj){
                indegree[n]--;
                if(indegree[n] == 0){
                    queue.add(n);
                }
            }
        }
        return ans;
    }

    private static int[] findInDegree(ArrayList<Integer>[] graph) {
        int[] indegree = new int[graph.length];
        for(ArrayList<Integer> e : graph){
            for(int node : e){
                indegree[node]++;
            }
        }
        return indegree;
    }
}
