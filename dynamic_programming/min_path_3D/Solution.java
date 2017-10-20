package min_path_3D;

import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner kb = new Scanner(System.in);
        int r = kb.nextInt();
        int c = kb.nextInt();

        int[][] path = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                path[i][j] = kb.nextInt();
            }
        }

        int dr = kb.nextInt();
        int dc = kb.nextInt();
        int res = solve(path, dr, dc);
        System.out.println(res);
    }

    public static int solve(int[][] path, int desR, int desC){
        int[][] dp = new int[path.length][path[0].length];
        dp[0][0] = path[0][0];
        for(int i = 1; i < dp.length; i++){
            dp[i][0] = dp[i - 1][0] + path[i][0];
        }
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = dp[0][j - 1] + path[0][j];
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = path[i][j] + min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]);
            }
        }
        printMatrix(dp);
        return dp[desR][desC];
    }

    public static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

    public static void printMatrix(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}