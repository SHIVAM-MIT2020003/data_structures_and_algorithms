package triple_step;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt();
        int res = tripleStep(n);
        System.out.println(res);
    }

    public static int tripleStep(int n){
        Map<Integer, Integer> brain = new HashMap<>();
        return tripleStep(n, brain);
    }

    //Memoisation
    public static int tripleStep(int n, Map<Integer, Integer> brain){
        if(n == 1)
            return 1;



        else if(n == 2)
            return 2;
        else if(n == 3)
            return 4;
        else{
            int f = 0, s = 0, t = 0;
            if(!brain.containsKey(n - 1))
                brain.put(n - 1, tripleStep(n - 1, brain));
            if(!brain.containsKey(n - 2))
                brain.put(n - 2, tripleStep(n - 2, brain));
            if(!brain.containsKey(n - 3))
                brain.put(n - 3, tripleStep(n - 3, brain));

            return brain.get(n - 1) + brain.get(n - 2) + brain.get(n - 3);
        }
    }

    //bottom up
    public static int DP(int n){
        int a = 1, b = 2, c = 4;
        if(n == 1)
            return a;

        if(n == 2)
            return b;

        if(n == 3)
            return c;

        int d = 0;
        for(int i = 4; i <= n; i++){
            d = c + b + a;
            a = b;
            b = c;
            c = d;
        }

        return c;
    }

    public static int countWays(int n){
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        else
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }
}
