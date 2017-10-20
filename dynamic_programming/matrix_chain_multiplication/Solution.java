package matrix_chain_multiplication;

import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        while(t-- > 0){
            int n = kb.nextInt();
            int[] mat = new int[n];
            for(int i = 0; i < n; i++){
                mat[i] = kb.nextInt();
            }

            int res = solve(mat);
            System.out.println(res);
        }
    }
    private static int solve(int[] mat){
        int size = mat.length;
        int[][] dp = new int[size][size];
        for(int i = 0; i < size; i++){
            dp[i][i] = 0;
        }

        int cost = 0;
        for(int len = 2; len < size; len++){
            for(int i = 1; i < size - len + 1; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k <= j - 1; k++){
                    cost = dp[i][k] + dp[k + 1][j] + mat[i - 1] * mat[k] * mat[j];
                    if(cost < dp[i][j]){
                        dp[i][j] = cost;
                    }
                }
            }
        }
        return dp[1][size - 1];
    }

    public static void printMatrix(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j] + " ");
            }

            System.out.println("");
        }
        System.out.println("");
    }

}