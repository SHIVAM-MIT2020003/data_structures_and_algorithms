package graph.geeksforgeeks;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GfG
{
    public static int[] topoSort(ArrayList<Integer> graph[], int N)
    {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                sortUtil(stack, i, visited, graph);
            }
        }
        int result[] = new int[graph.length];
        int count = 0;
        while(!stack.isEmpty()){
            result[count] = stack.pop();
            count++;
        }
        return result;
    }

    public static void sortUtil(Stack<Integer> stack, int i, boolean[] visited, ArrayList<Integer> graph[]){
        visited[i] = true;
        List<Integer> adjVertices = graph[i];
        for(int j=0; j<adjVertices.size(); j++){
            if (!visited[adjVertices.get(j)]){
                sortUtil(stack, adjVertices.get(j), visited, graph);
            }
        }
        stack.push(i);
    }
}