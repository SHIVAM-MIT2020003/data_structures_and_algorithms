package longest_common_subsequence;

import java.util.*;

class Solution{
    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);
        String first = kb.nextLine();
        String sec = kb.nextLine();
        int res = lcs2(first, sec);
        System.out.println(res);
    }

    public static int lcs2(String first, String second){
        int[][] matrix = new int[first.length() + 1][second.length() + 1];
        for(int i = 0; i < matrix.length; i++){
            matrix[i][0] = 0;
        }

        for(int j = 0; j < matrix[0].length; j++){
            matrix[0][j] = 0;
        }

        int lcsLen = 0;
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(first.charAt(i - 1) == second.charAt(j - 1)){
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }else{
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

    //branches ^ depth
    public static int lcs(String first, String sec){
        return lcs(first, sec, first.length(), sec.length());
    }
    public static int lcs(String first, String sec, int m, int n){
        if(m == 0 || n == 0)
            return 0;
        if(first.charAt(m - 1) == sec.charAt(n - 1))
            return 1 + lcs(first, sec, m - 1, n - 1);
        else
            return Math.max(lcs(first, sec, m - 1, n), lcs(first, sec, m, n - 1));
    }
}