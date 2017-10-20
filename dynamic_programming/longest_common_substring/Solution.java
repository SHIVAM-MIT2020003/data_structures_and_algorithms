package longest_common_substring;
import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String substring = lcsString(first, second);
        System.out.println(substring);
    }

    private static int longestCommonSubstring(String first, String second) {
        int[][] dp = new int[first.length() + 1][second.length() + 1];
        for(int i = 0; i < dp.length; i++)
            dp[i][0] = 0;

        for(int i = 0; i < dp[0].length; i++)
            dp[0][i] = 0;

        int maxLen = 0;
        for(int i = 1; i < dp.length; i++){
            for(int  j = 1; j < dp[0].length; j++){
                if(first.charAt(i - 1) == second.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }

    private static String lcsString(String first, String second) {
        int[][] dp = new int[first.length() + 1][second.length() + 1];
        for(int i = 0; i < dp.length; i++)
            dp[i][0] = 0;

        for(int i = 0; i < dp[0].length; i++)
            dp[0][i] = 0;

        int maxLen = 0;
        for(int i = 1; i < dp.length; i++){
            for(int  j = 1; j < dp[0].length; j++){
                if(first.charAt(i - 1) == second.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        int i = -1;
        int j = -1;
        outer:
        for(i = 0; i < dp.length; i++){
            for(j = 0; j < dp[0].length; j++){
                if(dp[i][j] == maxLen){
                    break outer;
                }
            }
        }
        String res = "";
        for(;i > 0 && j > 0; i--, j--){
            if(dp[i][j] == 0)
                break;

            res = first.charAt(i - 1) + res;
        }

        return res;
    }
}
