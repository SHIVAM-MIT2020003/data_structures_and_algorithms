package longest_increasing_subsequence.easy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[]ar)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int res = LIS(arr, n);
        System.out.println(res);
    }

    private static int LIS(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = -1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
