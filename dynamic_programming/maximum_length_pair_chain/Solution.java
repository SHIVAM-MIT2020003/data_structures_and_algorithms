package maximum_length_pair_chain;

import java.util.Arrays;

public class Solution {
    public static void main(String[]args){
        int[][] arr =  {{2,1}, {3,2}, {7,5}};
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
