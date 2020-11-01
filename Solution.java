
import java.util.*;

class Solution {


    public String kthSmallestPath(int[] destination, int k) {
        List<String> path = new ArrayList<>();
        dfs(0, 0, destination[0], destination[1], path, "");
        Collections.sort(path);
        return path.get(k - 1);

    }

    public void dfs(int sr, int sc, int dr, int dc, List<String> paths, String path){
        if(sr == dr && sc == dc) {
            paths.add(path);
            return;
        }
        if(sr > dr || sc > dc) return;


        dfs(sr + 1, sc, dr, dc, paths, path + "V");
        dfs(sr, sc + 1, dr, dc, paths, path + "H");
    }
}