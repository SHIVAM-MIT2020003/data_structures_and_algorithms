package graph.geeksforgeeks.detect_cycle_in_DAG;

import java.util.*;

public class Solution {

    public static void main(String[]a){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int e = kb.nextInt();

        LinkedList<Integer>[] graph = new LinkedList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < e; i++){
            int u = kb.nextInt();
            int v = kb.nextInt();
            graph[u].add(v);
        }
        System.out.println(hasCycle(n, graph, new boolean[n], new boolean[n]) ? "Yes" : "No");
    }

    public static boolean hasCycle(int v,LinkedList<Integer>[] alist,boolean[] visited,boolean[] explored)
    {
        visited = new boolean[v];
        explored = new boolean[v];

        for(int i = 0; i < v; i++){
            visited[i] = false;
            explored[i] = false;
        }

        for(int i = 0; i < v; i++){
            if(hasCycleUtil(i, alist, visited, explored)){
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycleUtil(int u, LinkedList<Integer> [] graph, boolean[] visited, boolean[] explored){
        if(!visited[u]){
            visited[u] = true;
            explored[u] = true;

            Iterator<Integer> adj = graph[u].listIterator();
            while(adj.hasNext()){
                int v = adj.next();
                if(!visited[v] && hasCycleUtil(v, graph, visited, explored)){
                    return true;
                }else if(explored[v]){
                    return true;
                }
            }
        }
        explored[u] = false;
        return false;
    }
}
