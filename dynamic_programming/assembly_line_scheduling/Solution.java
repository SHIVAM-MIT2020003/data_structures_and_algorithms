package assembly_line_scheduling;


import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    static int e1, e2;
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Station Count: ");
        int n = scanner.nextInt();
        int[] e = new int[2];
        System.out.println("Entry time: ");
        e[0] = scanner.nextInt();
        e[1] = scanner.nextInt();

        System.out.print("Line 1 station required Time: ");
        int[][] a = new int[2][n];
        for(int i = 0; i < n; i++){
            a[0][i] = scanner.nextInt();
        }

        System.out.print("Line 2 station required Time: ");
        for(int i = 0; i < n; i++){
            a[1][i] = scanner.nextInt();
        }


        int[] x = new int[2];
        System.out.println("Exit time: ");
        x[0] = scanner.nextInt();
        x[1] = scanner.nextInt();
        int[][] t = new int[n][n];
        System.out.println("shift time 1: ");
        for(int i = 0; i < n - 1; i++){
            t[0][i] = scanner.nextInt();
        }

        System.out.println("shift time 2: ");
        for(int i = 0; i < n - 1; i++){
            t[1][i] = scanner.nextInt();
        }

            String result = fastest_way(a, t, e, x, n);
            StringTokenizer stringTokenizer = new StringTokenizer(result);
            int f = Integer.parseInt(stringTokenizer.nextToken());
            int l = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println("f = " +  f + " l = " + l);

        }

    static int x1,x2;
    //Top down using Memoization.
    public static int minCost(int[][] a, int[][] t, int[] e, int[] x, int i, int j){
        if(i == 0 && j == 0){
            return e[0] + a[i][j];
        }

        if(i == 1 && j == 0){
            return e[1] + a[i][j];
        }
        if(j == a.length){
            int f1n = minCost(a, t, e, x, 0, j -1);
            int f1n2 = minCost(a, t, e, x, 1, j - 1);

            int f1n$ = Math.min(f1n, f1n2);

            int f2n = minCost(a, t, e, x, 1, j - 1);
            int f2n2 = minCost(a, t, e, x, 0, j - 1);
            int f2n$ = Math.min(f2n, f2n2);

             return Math.min(x[0] + f1n$, x[1] + f2n$);

        }else{
             return Math.min(a[i][j] + minCost(a, t, e, x, 0, j - 1), t[i][j] + a[i][j] + minCost(a, t, e, x, 1, j - 1));
        }
    }

    //Bottom up approach.
    public static String fastest_way(int[][] a, int[][] t, int[] e, int[] x, int n){

        int[][] f = new int[2][n];
        int[][] l = new int[2][n];

        f[0][0] = e[0] + a[0][0];
        f[1][0] = e[1] + a[1][0];

        for(int j = 1; j < n; j++){
            if(f[0][j - 1] + a[0][j] <= f[1][j - 1] + t[1][j - 1] + a[0][j]){
                f[0][j] = f[0][j - 1] + a[0][j];
                l[0][j] = 0;
            }else{
                f[0][j] = f[1][j - 1] + t[1][j - 1] + a[0][j];
                l[0][j] = 1;
            }

            if(f[1][j - 1] + a[1][j] <= f[0][j - 1] + t[0][j - 1] + a[1][j]){
                f[1][j] = f[1][j - 1] + a[1][j];
                l[1][j] = 1;
            }else{
                f[1][j] = f[0][j - 1] + t[0][j - 1] + a[1][j];
                l[0][j] = 0;
            }
        }

        int f$ = 0;
        int l$ = 0;

        if(x[0] + f[0][n - 1] <= x[1] + f[1][n - 1]){
            displayPath(l, l$);
            return (x[0] + f[0][n - 1] + " " + 0);

        }else{
            l$ = 1;
            displayPath(l, l$);
            return (x[1] + f[1][n - 1] + " " + 1);
        }
    }

    public static void displayPath(int[][] l, int l$){
        String pattern = "";
        pattern += l$;

        for(int i = l[0].length - 2; i >= 1; i--){
            pattern = l[l$][i] + " " + pattern;
            l$ = l[l$][i];
        }
        System.out.println(pattern);
    }
}
