package Minimum_Steps_to_One;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ways = DP(n);
        System.out.println(ways);
    }

    public static int calculateWays(int n){
        return calculateWays(n, new HashMap<Integer, Integer>());
    }

    //Memoization.
    public static int calculateWays(int n, Map<Integer, Integer> map){
        if(n == 1){
            return  0;
        }

        if(map.containsKey(n))
            return map.get(n);

        int ways = 1 + calculateWays(n - 1);
        if(n % 2 == 0){
            ways = Math.min(ways,1 + calculateWays(n / 2));
        }

        if(n % 3 == 0){
            ways = Math.min(ways, 1 + calculateWays(n / 3));
        }
        map.put(n, ways);
        return ways;
    }

    //Dynamic programming

    public static int DP(int n){
        int[] arr = new int[n + 1];
        arr[1] = 0;
        for(int i = 2; i <= n; i++){
            arr[i] = 1 + arr[i - 1];
            if(i % 2 == 0)
                arr[i] = Math.min(arr[i], 1 + arr[i / 2]);

            if(i % 3 == 0)
                arr[i] = Math.min(arr[i], 1 + arr[i / 3]);

        }

        return arr[n];
    }
}
