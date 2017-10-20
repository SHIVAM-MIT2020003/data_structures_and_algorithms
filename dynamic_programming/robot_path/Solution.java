package robot_path;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[]a){
        Scanner scanner =  new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int res = paths(r, c);
        System.out.println(res);
    }

    public static int paths(int r, int c){
        int[][] matrix = new int[r + 1][c + 1];
        //Arrays.fill(matrix, 0);

        matrix[r - 1][c] = 1;

        for(int i = r - 1; i >= 0; i--){
            for(int j = c - 1; j >= 0; j--){
                matrix[i][j] = matrix[i][j + 1] + matrix[i + 1][j];
            }
        }
        return matrix[0][0];
    }


}
