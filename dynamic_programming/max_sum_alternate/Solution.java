package max_sum_alternate;

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();

        while(t-- > 0){
            int n = kb.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n;  i++){
                arr[i] = kb.nextInt();
            }

            int res = solve(arr);
            System.out.println(res);
        }
    }

    public static int solve(int[] arr){
        if(arr.length == 1)
            return arr[0];

        if(arr.length == 2)
            return Math.max(arr[0], arr[1]);

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], dp[1]);

        for(int i = 2; i < arr.length; i++){
            dp[i] = Math.max(dp[i - 2]  + arr[i], dp[i - 1]);
        }
        return dp[arr.length - 1];
    }
}