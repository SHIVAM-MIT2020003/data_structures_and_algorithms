package n_digit_non_decreasing;

import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int result = solve(num);
        System.out.println(result);
    }

    public static int solve(int n){
        int[][] matrix = new int[n + 1][10];

        for(int i = 0; i < 10; i++){
            matrix[0][i] = 1;
        }

        for(int i = 1; i <= n; i++){
            matrix[i][9] = 1;
        }

        for(int  i = 1; i <= n; i++){
            for(int j = 8; j >= 0; j--){
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j + 1];
            }
        }
        return matrix[n][0];
    }
}
