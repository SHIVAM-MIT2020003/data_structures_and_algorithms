package recursive_multiply;

import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int res = multiply(n, m);
        System.out.println(res);
    }

    static int[] memo;
    static{
       memo = new int[10001];
    }

    public static int multiply(int a, int b){
        int smaller = a <= b ? a : b;
        int bigger = a > b ? a : b;

        return multiply(smaller, bigger, memo);
    }

    public static int multiply(int smaller, int bigger, int[] memo){
        if(smaller == 0){
            return 0;
        }

        if(smaller == 1){
            return bigger;
        }
        if(memo[smaller] > 0){
            return memo[smaller];
        }

        int s = smaller >> 1;
        int side1 = multiply(s, bigger, memo);
        int side2 = side1;
        if(smaller % 2 == 1){
            side2 = multiply(smaller - s, bigger);// if one number is even then we must restart from scratch.
        }

        memo[smaller] = side1 + side2;
        return memo[smaller];
    }
}
