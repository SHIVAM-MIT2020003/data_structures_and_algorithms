package egg_dropping_problem;

import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int res = solve(n, e);
        System.out.println(res);
    }

    //recursive solution.
    public static int solve(int n, int e){
        if(e == 1){
            return n;
        }

        if(n == 1)
            return 1;

        int min = 0;
        for(int i = 0; i < n; i++){
            min = Math.min(min, Math.max(solve(n - i, e), solve(i - 1, e - 1)) + 1);
        }
        return min;
    }
}
