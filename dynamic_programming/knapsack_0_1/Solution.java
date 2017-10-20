package knapsack_0_1;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int test = kb.nextInt();
        while(test-- > 0){
            int noOfItems = kb.nextInt();
            int sackSize = kb.nextInt();

            int[][] matrix = new int[noOfItems][sackSize + 1];
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }

            int[][] items = new int[2][noOfItems];

            for(int i = 0; i < noOfItems; i++){
                items[1][i] = kb.nextInt();
            }

            for(int i = 0; i < noOfItems; i++){
                items[0][i] = kb.nextInt();
            }

            for(int i = 0; i < matrix.length; i++){
                for(int j = 1; j < matrix[0].length; j++){
                    if(i == 0){
                        matrix[i][j] = items[1][0];
                    }else if(j < items[0][i]){
                        matrix[i][j] = matrix[i - 1][j];
                    }else{
                        matrix[i][j] = Math.max(matrix[i - 1][j], items[1][i] + matrix[i - 1][j - items[0][i]]);
                    }
                }
            }
            System.out.println(matrix[matrix.length - 1][matrix[0].length - 1]);
        }
    }
}