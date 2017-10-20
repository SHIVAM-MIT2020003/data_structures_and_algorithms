package Minimum_number_of_coins_for_possible_sum;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int size = kb.nextInt();
        int val = kb.nextInt();
        int[] coins = new int[size];
        for(int i = 0; i < size; i++){
            coins[i] = kb.nextInt();
        }

        int res = solve(coins, val);
        System.out.println(res);

    }

    public static int solve(int[] c, int val){
        Arrays.sort(c);
        int[] dp = new int[val + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;

        for(int i = 1; i <= val; i++){
            for(int j = 0; j < c.length; j++){
                if(i - c[j] == 0){
                    dp[i] = 1;
                }else if(i - c[j] > 0){
                    dp[i] = Math.min(dp[i], dp[i - c[j]] + 1);
                }
            }

        }
        print(dp);
        return dp[val];
    }

    public static void print(int[] dp){
        for(int i = 0; i < dp.length; i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}