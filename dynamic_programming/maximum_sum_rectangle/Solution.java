package maximum_sum_rectangle;

import java.util.Scanner;

public class Solution {
    public static void main(String[]a){
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while(test-- > 0){
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int[][] mat = new int[row][col];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    mat[i][j] = scanner.nextInt();
                }
            }

            int res = Integer.MIN_VALUE;

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    res = Math.max(res, maxSumRec(mat, i, j));

                }
            }
            System.out.println(res);
        }
    }

    public static int maxSumRec(int[][] mat, int r, int c){
        int[][] newMat = new int[mat.length + 1][mat[0].length + 1];

        int max = Integer.MIN_VALUE;

        for(int i = r + 1; i < newMat.length; i++){
            for(int j = c + 1; j < newMat[0].length; j++){
                newMat[i][j] = newMat[i][j - 1] + newMat[i - 1][j] - newMat[i - 1][j - 1] + mat[i - 1][j - 1];
                max = Math.max(max, newMat[i][j]);
            }
        }

        return max;
    }
}
