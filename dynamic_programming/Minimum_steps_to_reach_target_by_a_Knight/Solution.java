package Minimum_steps_to_reach_target_by_a_Knight;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int[] rowH = {2, 1, 2, 1, -2, -1, -2, -1};
    static int[] colH = {-1, -2, 1, 2, -1, -2, 1, 2};
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//size of chess.
        int kr = scanner.nextInt();// position of knight
        int kc = scanner.nextInt();
        int tr = scanner.nextInt();// target position
        int tc = scanner.nextInt();
        int minStepRequired = BFS(new int[]{kr, kc}, new  int[]{tr, tc}, N);
        System.out.println(minStepRequired);
    }

    static class Cell{
        int row, col, distance;
        public Cell(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    private static int BFS(int[] src, int[] des, int N){
        boolean[][] isVisited = new boolean[N][N];
        Queue<Cell> queue = new LinkedList<>();
        Cell cell = new Cell(src[0], src[1], 0);
        queue.offer(cell);
        while (!queue.isEmpty()){
            Cell t = queue.poll();
            if(t.row == des[0] && t.col == des[1]){
                return t.distance;
            }else{
                for(int i = 0; i < 8; i++){
                    int x = t.row + rowH[i];
                    int y = t.col + colH[i];
                    if(isInside(x,  y, N) && !isVisited[x][y]){
                        queue.offer(new Cell(x, y, t.distance + 1));
                        isVisited[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isInside(int x, int y, int n) {
        if(x >= 0 && y >= 0 && x < n && y < n)
            return true;
        else
            return false;
    }
}
