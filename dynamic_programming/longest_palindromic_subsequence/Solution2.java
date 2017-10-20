package longest_palindromic_subsequence;

import java.util.Scanner;
public class Solution2 {
    public static void main(String[]args){
      Scanner scanner = new Scanner(System.in);
      String pattern = scanner.nextLine();
      int l = lps(pattern);
      System.out.println(l);
    }

    public static int lps(String pattern){
        String palindrome = "";
        int[][] M = new int[pattern.length() + 1][pattern.length() + 1];
        char[][] D = new char[pattern.length() + 1][pattern.length() + 1];
        for(int i = 0; i < M.length; i++){
            M[0][i] = 0;
            M[i][M.length - 1] = 0;
            D[0][i] = '0';
            D[i][D.length - 1] = '0';
        }

        for(int i = 1; i < M.length; i++){
            for(int j = M.length - 2; j >= 0; j--){
                if(pattern.charAt(i - 1) == pattern.charAt(j)){
                    M[i][j] =  M[i - 1][j + 1] + 1;
                    D[i][j] = 'D';
                }else{
                    M[i][j] = Math.max(M[i - 1][j], M[i][j + 1]);
                    if(M[i][j] == M[i - 1][j]){
                        D[i][j] = 'U';
                    }else{
                        D[i][j] = 'R';
                    }
                }
            }
        }

        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                System.out.print(M[i][j] + " ");
            }
            System.out.println("");
        }

        int i = M.length - 1;

        int j = 0;
        while(D[i][j] != '0' && D[i][j] != '0'){
            if(D[i][j] == 'D'){
                palindrome += pattern.charAt(i - 1);
                i--;
                j++;
            }else if(D[i][j] == 'U'){
                i -= 1;
            }else{
                j++;
            }
        }
        System.out.println(palindrome);
        return palindrome.length();
    }

    public static int max(int a, int b, int c){
        return Math.max(Math.max(a, b),c);
    }
}
