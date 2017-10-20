package reach_a_given_score;

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        while(t-- > 0){
            int score = kb.nextInt();
            int res = solve(score);
            System.out.println(res);
        }
    }

    public static int solve(int s){
        int[] dp = new int[s + 1];
        dp[0] = 1;
        int t = 0;
        for(int i = 1; i <= s; i++){
            t = i;
            if(t - 3 >= 0){
                dp[i] += dp[t - 3];
                t -= 3;
            }else if(t - 5 >= 0){
                dp[i] += dp[t - 5];
                i -= 5;
            }

            if(i - 10 >= 0){
                dp[i] += dp[i - 10];
                i -= 10;
            }
        }
        return dp[s];
    }
}