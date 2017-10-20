package subset_sum_problem;

import java.util.Scanner;

public class Solution {
    public static boolean subSet(int[] set, int sum){
        boolean[][] matrix = new boolean[set.length][sum + 1];
        for(int i = 0; i < matrix.length; i++){
            matrix[i][0] = true;
        }

        for(int i = 0; i < set.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(i == 0){
                    if(set[i] == j){
                        matrix[i][j] = true;
                    }else{
                        matrix[i][j] = false;
                    }
                }else {
                    if(matrix[i- 1][j]){
                        matrix[i][j] = true;
                    }else{
                        if(set[i] <= j && matrix[i - 1][j - set[i]]){
                            matrix[i][j] = true;
                        }else{
                            matrix[i][j] = false;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        return matrix[matrix.length - 1][matrix[0].length - 1];
    }



    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int setSize = scanner.nextInt();
        int[] set = new int[setSize];
        for(int i = 0; i <  setSize; i++){
            set[i] = scanner.nextInt();
        }
        int sum = scanner.nextInt();
        boolean result = subSet(set, sum);
        if(result){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
